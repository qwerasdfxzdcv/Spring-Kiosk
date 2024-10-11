package com.example.kiosk.store.request;

import com.example.kiosk.store.domain.Store;

public record StoreResponse(String storeName, String storeAddress, int storeId, int storeOpentime, int storeClosetime) {
    public static StoreResponse from(Store store){
        return new StoreResponse(
                store.getStoreName(),
                store.getStoreAddress(),
                store.getStoreId(),
                store.getStoreOpentime(),
                store.getStoreClosetime());
    }
}
