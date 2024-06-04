package com.example.accountidsystem.infra.repository;

import com.example.accountidsystem.core.domain.FunctionMap;
import com.example.accountidsystem.core.domain.asset.AssetType;
import com.example.accountidsystem.core.repository.FunctionRepository;
import com.example.accountidsystem.infra.repository.dao.FunctionDao;
import com.example.accountidsystem.infra.repository.entity.FunctionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FunctionRepositoryImpl implements FunctionRepository {
    private final FunctionDao dao;
    @Override
    public Mono<FunctionMap> getLatestActiveFunction(AssetType accountIdType) {
        return dao.findFirstByAssetTypeAndStatusOrderByVersion(accountIdType.name(), "ACTIVE")
                .map(this::toDomain);
    }

    private FunctionMap toDomain(FunctionEntity functionMap) {
        return FunctionMap.builder()
                .id(functionMap.getId())
                .assetType(AssetType.valueOf(functionMap.getAssetType()))
                .formula(functionMap.getFormula())
                .version(functionMap.getVersion())
                .status(functionMap.getStatus())
                .build();
    }
}
