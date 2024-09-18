package ru.skillbox.spring_client_auth_example.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.skillbox.spring_client_auth_example.client.BasicAuthClient;
import ru.skillbox.spring_client_auth_example.client.JwtAuthClient;
import ru.skillbox.spring_client_auth_example.web.model.AuthRequest;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class AppController {


    // Для базовой аунтефикации (по логину и паролю
    //private final BasicAuthClient basicAuthClient;

//    @PostMapping
//    public Mono<String> authRequest(@RequestBody AuthRequest authRequest) {
//        return basicAuthClient.getData(authRequest);
//    }

    private final JwtAuthClient jwtAuthClient;

    @GetMapping
    public Mono<String> authRequest() {
        return jwtAuthClient.getData();
    }
}
