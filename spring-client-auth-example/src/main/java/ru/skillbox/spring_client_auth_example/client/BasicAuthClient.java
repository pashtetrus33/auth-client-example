package ru.skillbox.spring_client_auth_example.client;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.skillbox.spring_client_auth_example.web.model.AuthRequest;

@Component
@RequiredArgsConstructor
public class BasicAuthClient {

    @Value("${app.user.path}")
    private String userApiPath;

    private final WebClient defaultWebClient;

    public Mono<String> getData(AuthRequest authRequest) {
        return defaultWebClient.get()
                .uri(userApiPath)
                .headers(h -> h.setBasicAuth(authRequest.getUsername(), authRequest.getPassword()))
                .retrieve()
                .bodyToMono(String.class);
    }
}
