package com.vignesh.basics.resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Function;
import java.util.stream.IntStream;

public class RateLimiterTest {

    public static final Logger log = LoggerFactory.getLogger(RateLimiterTest.class);

    private static RateLimiter rateLimiter;
    private static WebClient webClient;

    @BeforeAll
    public static void init() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .limitForPeriod(10)
                .timeoutDuration(Duration.ofMillis(100))
                .build();
        // Create registry
        RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.of(config);

        // Use registry
        rateLimiter = rateLimiterRegistry
                .rateLimiter("default");
        webClient = WebClient.create("http://localhost:9000");
    }

    @Test
    public void testRestClient() {
        Function<Integer, String> decorated = RateLimiter.decorateFunction(rateLimiter, (i) ->
                this.processGet(i)
        );
        IntStream.range(1, 20).forEach(i -> { decorated.apply(200);
        });
    }

    @Test
    public void testKafkaListener() {

    }

    public String processGet(int s) {
        log.info("called");
        WebClient.RequestHeadersUriSpec<?> getAPISpec = webClient.get();
        Mono<String> monoBody = getAPISpec.uri("/"+ s).exchangeToMono(response -> response.bodyToMono(String.class));
        return monoBody.block();
    }
}
