package com.example.accountidsystem.core.repository;

import com.example.accountidsystem.core.domain.FunctionMap;
import com.example.accountidsystem.core.domain.asset.AssetType;
import reactor.core.publisher.Mono;

public interface FunctionRepository {
    Mono<FunctionMap> getLatestActiveFunction(AssetType accountIdType);
}
