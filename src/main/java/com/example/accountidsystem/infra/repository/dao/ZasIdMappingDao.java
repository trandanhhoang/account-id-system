package com.example.accountidsystem.infra.repository.dao;

import com.example.accountidsystem.infra.repository.entity.ZasIdMapping;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;

public interface ZasIdMappingDao
        extends ReactiveCrudRepository<ZasIdMapping, BigInteger> {

}
