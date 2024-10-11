package com.example.kiosk.store;

import org.springframework.stereotype.Service;

import java.util.List;

// controller 유저와 개발자의 소통 공간
// service 개발자의 생각 공간
// repository 개발자와 data 간의 소통 공간
@Service // @Component 와 같음
public class StoreServiceImpl implements StoreService {
    public List<StoreResponse> getAllStores() {
        List<StoreResponse> list = Utils.stores
                .stream()
                .map(StoreResponse::from)
                .toList();
        return list;
    }

    public Store getStoreById(int id) {
        return Utils.stores
                .stream()
                .filter(el -> el.getStoreId() == id && !el.isDeleted())
                .findFirst()
                .orElseThrow(()->new StoreNotFoundException(id));
    }

    public Store addStore(StoreRequest request) {
        Store store = request.toStore();
        Utils.stores.add(store);
        return store;
    }

    public void deleteStore(int id) {
        Store target = getStoreById(id);
        target.delete();
    }

    public Store updateStore(int id, StoreRequest request){
        return getStoreById(id).update(request);
    }
}