package com.example.apigatewayservices.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openEAPIndPoints = List.of(
            "/auth/register",
            "/auth/token",
            "/eureka",
            "/hello",
            "/helloTwo"
            //"/validate"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openEAPIndPoints.stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
