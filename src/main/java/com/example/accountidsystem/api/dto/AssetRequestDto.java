package com.example.accountidsystem.api.dto;

import com.example.accountidsystem.core.domain.asset.AssetType;
import com.example.accountidsystem.core.domain.asset.BankAsset;
import com.example.accountidsystem.core.domain.asset.MerchantAsset;
import com.example.accountidsystem.core.domain.asset.UserAsset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AssetRequestDto {
    private AssetType assetType;
    private UserAsset userAsset;
    private MerchantAsset merchantAsset;
    private BankAsset bankAsset;
}
