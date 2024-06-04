package com.example.accountidsystem.core.service;

import com.example.accountidsystem.core.domain.FunctionMap;
import com.example.accountidsystem.core.domain.asset.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyProvider {


    /**
     * calculate key by formula from functionMap, value from asset
     *
     * @param functionMap: contain formula
     * @param asset: contain value to apply into formula
     * @return key
     */
    public String getKey(FunctionMap functionMap, Asset asset) {
        if (!functionMap.getAssetType().equals(asset.getAssetType())) {
            throw new RuntimeException("Asset type mismatch");
        }

        List<String> extractedValues = new ArrayList<>();

        // reflection to get field from assetComponent
        try {
            String[] keys = functionMap.getFormula().split("\\|");

            Class<?> clazz = asset.getAssetComponent().getClass();
            for (String fieldName : keys) {
                Field field = clazz.getDeclaredField(fieldName);;
                field.setAccessible(true);
                Object value = field.get(asset.getAssetComponent());
                if (value == null){
                    throw new RuntimeException("value of field is null");
                }
                extractedValues.add((String) value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return String.join("|", extractedValues);
    }
}
