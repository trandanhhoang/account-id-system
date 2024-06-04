package com.example.accountidsystem.core.domain.asset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Asset {
    private AssetType assetType;
    private AssetComponent assetComponent;
}
