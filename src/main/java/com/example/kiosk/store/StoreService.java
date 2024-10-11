package com.example.kiosk.store;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StoreService {
    List<StoreResponse> getAllStores();
    Store getStoreById(int id);
    void deleteStore(int id);
    Store updateStore(int id, StoreRequest request);
    Store addStore(StoreRequest request);
}
