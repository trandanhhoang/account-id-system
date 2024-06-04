package com.example.accountidsystem.api.controller;


import com.example.accountidsystem.api.dto.AssetRequestDto;
import com.example.accountidsystem.core.domain.asset.Asset;
import com.example.accountidsystem.core.domain.asset.AssetComponent;
import com.example.accountidsystem.core.service.AccountIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.example.accountidsystem.core.domain.asset.AssetType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/internal/account-id")
public class InternalAccountController {

    private final AccountIdService accountIdService;

    /**
     * @param assetRequestDto: detect type of accounting_id base on {@link AssetType}
     * @return String "SUCCESS" if register success
     */
    @PostMapping("/register")
    public Mono<String> registerAsset(@RequestBody AssetRequestDto assetRequestDto) {
        Asset asset = Asset.builder()
                .assetType(assetRequestDto.getAssetType())
                .assetComponent(toAssetComponent(assetRequestDto))
                .build();
        return accountIdService.registerAsset(asset)
                .flatMap(zasIdMap -> Mono.just("SUCCESS"));
    }

    private AssetComponent toAssetComponent(AssetRequestDto dto) {
        switch (dto.getAssetType()) {
            case USER -> {
                return dto.getUserAsset();
            }
            case MERCHANT -> {
                return dto.getMerchantAsset();
            }
            case BANK -> {
                return dto.getBankAsset();
            }
            default -> throw new RuntimeException("can not detect asset type");
        }
    }
}

