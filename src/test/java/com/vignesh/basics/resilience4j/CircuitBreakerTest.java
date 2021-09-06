package com.vignesh.basics.resilience4j;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.IntStream;

public class CircuitBreakerTest {

    private static CircuitBreaker circuitBreaker;
    private static RestTemplate restTemplate;

    public static final Logger log = LoggerFactory.getLogger(CircuitBreakerTest.class);

    @BeforeAll
    public static void init() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .permittedNumberOfCallsInHalfOpenState(2)
                .minimumNumberOfCalls(10)
                .waitDurationInOpenState(Duration.ofSeconds(5))
                .slidingWindowSize(10)
//                .recordExceptions(HttpServerErrorException.class)
                .build();
        CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(config);
        circuitBreaker = circuitBreakerRegistry.circuitBreaker("default");
        restTemplate = new RestTemplate();
    }

    /*
     * minimumNumberOfCalls(10) - so will record results of at least 10 calls
     * failureRateThreshold(50) - after 50 % calls failed. i.e 5 calls failed, change to OPEN state
     * in OPEN state - calls will by rejected immediately to save resources
     * waitDurationInOpenState(5) - after 5 seconds state will be changed to HALF_OPEN to check if the target service is responding.
     * permittedNumberOfCallsInHalfOpenState(2) - 2 calls will be permitted to check if the failure response rate is less than 50%
     * if HALF_OPEN records more than failureRateThreshold,then OPEN state will remain for another waitDurationInOpenState
     */

    @Test
    public void testRestClient() {
        Function<String, String> decorateFunction = CircuitBreaker.decorateFunction(circuitBreaker, url -> restTemplate.getForObject(url, String.class));
        log.info("Circuit breaker STATE : closed");
        boolean isClosed = false;
        IntStream.range(1, 25).forEach(i -> {
            log.info(String.valueOf(i));
            String url = "http://localhost:9000/200";
            if (i > 5 && i < 19) {
                //no server. so will get connect timeout exception
                url = "http://192.168.0.30:9001";
            }
            try {
                decorateFunction.apply(url);
                log.info("success");
            } catch (RestClientException e) {
                log.info("failed : {}", e.getMessage());
            } catch (CallNotPermittedException e) {
                log.info("Circuit breaker STATE : opened");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
    }
}
