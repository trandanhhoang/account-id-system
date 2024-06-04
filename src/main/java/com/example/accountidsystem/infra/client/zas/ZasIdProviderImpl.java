package com.example.accountidsystem.infra.client.zas;

import com.example.accountidsystem.core.service.ZasProvider;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class ZasIdProviderImpl implements ZasProvider {
    @Override
    public Mono<String> getZasId() {
        return Mono.just(UUID.randomUUID().toString());
    }
}
