package com.example.kiosk.store.service;

import com.example.kiosk.store.domain.Store;
import com.example.kiosk.store.request.StoreRequest;
import com.example.kiosk.store.request.StoreResponse;

import java.util.List;

public interface StoreService {
    List<StoreResponse> getAllStores();
    Store getStoreById(int id);
    void deleteStore(int id);
    Store updateStore(int id, StoreRequest request);
    Store addStore(StoreRequest request);
}
