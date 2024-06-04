package com.example.accountidsystem.core.domain.asset;

import lombok.Data;

@Data
public class MerchantAsset implements AssetComponent {
    private String accountingCode;
    private String appId;
    private String paymentId;
}