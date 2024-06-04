package com.example.accountidsystem.core.service;

import com.example.accountidsystem.core.domain.FunctionMap;
import com.example.accountidsystem.core.domain.ZasIdMap;
import com.example.accountidsystem.core.domain.asset.Asset;
import com.example.accountidsystem.core.repository.FunctionRepository;
import com.example.accountidsystem.core.repository.ZasIdMappingRepository;
import com.example.accountidsystem.infra.repository.entity.ZasIdMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountIdService {
    private final FunctionRepository functionRepository;
    private final ZasIdMappingRepository zasIdMappingRepository;
    private final ZasProvider zasProvider;
    private final KeyProvider keyProvider;


    /**
     * Register asset from UM, Bank, Merchant, ...
     * @param asset
     * @return {@link ZasIdMap} that contain key and value.
     */
    public Mono<ZasIdMap> registerAsset(Asset asset) {
        return functionRepository.getLatestActiveFunction(asset.getAssetType())
                .flatMap(function -> getKeyAndSaveZasIdMapping(function, asset));
    }

    private Mono<ZasIdMap> getKeyAndSaveZasIdMapping(FunctionMap functionMap, Asset asset) {
        String key = keyProvider.getKey(functionMap, asset);
        return zasProvider.getZasId()
                .flatMap(value ->
                        persistZasIdMap(functionMap, key, value)
                );
    }

    private Mono<ZasIdMap> persistZasIdMap(FunctionMap functionMap, String key, String value) {
        ZasIdMapping zasIdMapping = ZasIdMapping.builder()
                .functionId(String.valueOf(functionMap.getId()))
                .assetType(functionMap.getAssetType().name())
                .key(key)
                .value(value)
                .build();
        return zasIdMappingRepository.saveZasIdMapping(zasIdMapping);
    }
}
