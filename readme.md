# Description
- The first basic version that support register asset

# How to run 

- $ docker volume create local-postgres-v15
- $ docker-compose up -d

- create database: account-id

- call postman:
  - curl --location 'localhost:8080/api/account-id-system/v1/internal/account-id/register' \
    --header 'Content-Type: application/json' \
    --data '{
    "assetType":"USER",
    "userAsset":{
    "accountCode":"accountCodeHoang",
    "userId":"hoang"
    }
    }'