package com.example.accountidsystem.infra.repository;

import com.example.accountidsystem.core.domain.ZasIdMap;
import com.example.accountidsystem.infra.repository.entity.ZasIdMapping;
import com.example.accountidsystem.core.repository.ZasIdMappingRepository;
import com.example.accountidsystem.infra.repository.dao.ZasIdMappingDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ZasIdMappingRepositoryImpl implements ZasIdMappingRepository {
    private final ZasIdMappingDao dao;

    @Override
    public Mono<ZasIdMap> saveZasIdMapping(ZasIdMapping entity) {
        return dao.save(entity)
                .map(this::toDomain);
    }

    private ZasIdMap toDomain(ZasIdMapping entity) {
        return ZasIdMap.builder()
                .key(entity.getKey())
                .value(entity.getValue())
                .build();
    }
}
