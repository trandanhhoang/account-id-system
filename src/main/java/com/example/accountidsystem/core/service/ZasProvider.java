package com.example.accountidsystem.core.service;

import reactor.core.publisher.Mono;

public interface ZasProvider {
    Mono<String> getZasId();
}
