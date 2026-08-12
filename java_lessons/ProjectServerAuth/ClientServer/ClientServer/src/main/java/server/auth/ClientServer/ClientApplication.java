package server.auth.ClientServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @RestController
    public class ClientController {
        @Autowired
        private OAuth2RestTemplate restTemplate;

        @GetMapping("/getCatImage")
        public ResponseEntity<String> getCatImage() {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept( Collections.singletonList( MediaType.APPLICATION_JSON));

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    "http://localhost:8080/api/cat",
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            return ResponseEntity.status(response.getStatusCode()).headers(response.getHeaders()).body(response.getBody());
        }
    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ClientContext clientContext,
                                                 OAuth2ProtectedResourceDetails details) {
        return new OAuth2RestTemplate(details, clientContext);
    }
}


