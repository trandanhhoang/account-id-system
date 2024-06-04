package com.example.accountidsystem.core.domain.asset;

import lombok.Data;

@Data
public class BankAsset implements AssetComponent{
    private String accountingCode;
    private String escrowNo;
}
