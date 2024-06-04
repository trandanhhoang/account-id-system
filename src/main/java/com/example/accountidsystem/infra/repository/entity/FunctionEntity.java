package com.example.accountidsystem.infra.repository.entity;


import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "function_mapping")
public class FunctionEntity {
    @Id private BigInteger id;
    private String assetType;
    private String formula;
    private String version;
    private String status;
}
