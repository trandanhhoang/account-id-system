package com.example.accountidsystem.core.service;

import reactor.core.publisher.Mono;

public interface ZasProvider {
    /**
     * Get ZasId by call grpc to another service
     * @return ZasId
     */
    Mono<String> getZasId();
}
