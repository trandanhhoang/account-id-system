package com.example.accountidsystem.infra.repository.entity;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Table(name = "zas_id_mapping")
@Builder
@Getter
@Setter
public class ZasIdMapping {
    @Id private BigInteger id;
    private String assetType;
    private String key;
    private String value;
    private String functionId;
}
