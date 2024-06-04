package com.example.accountidsystem.core.domain.asset;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAsset implements AssetComponent {
    private String accountCode;
    private String userId;
}
