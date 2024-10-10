package com.example.kiosk.store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StoreController {
    @GetMapping
    public List<Store> getAllStores() {
        return Utils.stores;
    }
    public Store getStoreById(){
        
        return null;
    }
    // get 방식은 body 가 없고 post 방식은 body 가 있다
    @PostMapping
    public Store saveStore(
        @RequestBody StoreRequest request
    ) {
        Store store = request.toStore();
        Utils.stores.add(store);
        return store;
    }

    public static void main(String[] args) {
        Store store = new Store("매머드", "서울", 7, 21);
        Store store2 = new Store("깐부", "서울", 11, 1);
        Utils.stores.add(store);
        Utils.stores.add(store2);
        List<Store> allStores = new StoreController().getAllStores();
        for(int i = 0; i < allStores.size(); i++) {
            if(!Utils.stores.get(i).equals(allStores.get(i)))
                throw new RuntimeException();
        }
        System.out.println("굳 잡");
    }
}
