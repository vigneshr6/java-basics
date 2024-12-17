package com.vignesh.basics.restjson;

import com.vignesh.basics.util.TestUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class HttpClientsTest {

    private static final String url = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void testApacheHttpClient() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        String json = TestUtil.marshalToJSON(getNewUser());
        request.setEntity(new StringEntity(json));
        CloseableHttpResponse response = client.execute(request);
        Assertions.assertEquals(201, response.getStatusLine().getStatusCode());
        System.out.println("Response : "+response.getEntity().toString());
    }
    
    @Test
    public void testSpringRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> users = restTemplate.getForEntity(url, List.class);
        System.out.println("Users : "+users.getBody().toString());
    }

    private User getNewUser() {
        return new User(1, "vicky","vicky@example.com","123");
    }
}
