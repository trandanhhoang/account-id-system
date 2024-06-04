package com.example.accountidsystem.core.repository;

import com.example.accountidsystem.core.domain.ZasIdMap;
import com.example.accountidsystem.infra.repository.entity.ZasIdMapping;
import reactor.core.publisher.Mono;

public interface ZasIdMappingRepository {

    Mono<ZasIdMap> saveZasIdMapping(ZasIdMapping entity);
}
