package com.example.accountidsystem.infra.repository.dao;

import com.example.accountidsystem.infra.repository.entity.FunctionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface FunctionDao
        extends ReactiveCrudRepository<FunctionEntity, BigInteger> {

    Mono<FunctionEntity> findFirstByAssetTypeAndStatusOrderByVersion(String assetType, String status);

}
