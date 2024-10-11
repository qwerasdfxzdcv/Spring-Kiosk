package com.example.kiosk.store;

public record StoreResponse(String storeName, String storeAddress, int storeOpentime, int storeClosetime, int storeId) {
    public static StoreResponse from(Store store){
        return new StoreResponse(
                store.getStoreName(),store.getStoreAddress(),store.getStoreId(),
                store.getStoreOpentime(),store.getStoreClosetime());
    }
}
