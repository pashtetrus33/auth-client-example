package ru.skillbox.spring_client_auth_example.client;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtAuthClient {

    @Value("${app.data.path}")
    private String dataPath;

    private final WebClient jwtWebClient;

    public Mono<String> getData() {
        return jwtWebClient.get()
                .uri(dataPath)
                .retrieve()
                .bodyToMono(String.class);

    }
}
