package com.vignesh.basics.restjson;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource("/jsonapp.properties")
//@EnableConfigurationProperties(ClientProperties.class)
public class RestClientTest {

    @Autowired
    private ClientProperties props;

    @Test
    public void testGetMsgCount() {
        RestTemplate restTemplate = getRestTemplate();
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final List<CompletableFuture<User>> futures = props.getUserIds().stream().map(id ->
                CompletableFuture.supplyAsync(() ->
                                restTemplate.getForEntity(getUserURL(id), User.class).getBody()
                        , executorService)
        ).collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        final List<User> users = futures.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        Collections.sort(users, Comparator.comparing(User::getName));
        final int maxNameLen = users.stream().mapToInt(data -> data.getName().length()).max().orElse(0) + 5;
        final int maxEmailLen = users.stream().mapToInt(data -> String.valueOf(data.getEmail()).length()).max().orElse(0);
        String box = String.format("+%s+", "-".repeat(maxNameLen + maxEmailLen + 5));
        System.out.println(box);
        IntStream.range(0, users.size()).forEach(i -> {
            final User data = users.get(i);
            System.out.printf("| %-" + maxNameLen + "s | %-" + maxEmailLen + "s |\n", data.getName(), data.getEmail());
            if (i < users.size() - 1) {
                System.out.println("-".repeat(maxNameLen + maxEmailLen + 7));
            }
        });
        System.out.println(box);
    }


    private String getUserURL(long id) {
        return props.getUrl() + "/" + id;
    }

    private RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("fssreader", "fssreader"));
        return restTemplate;
    }
}
