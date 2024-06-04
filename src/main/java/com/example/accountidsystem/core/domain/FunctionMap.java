package com.example.accountidsystem.core.domain;

import com.example.accountidsystem.core.domain.asset.AssetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class FunctionMap {
    private BigInteger id;
    private AssetType assetType;
    private String formula;
    private String version;
    private String status;
}
