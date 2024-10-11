package com.example.kiosk.store.request;

import com.example.kiosk.store.domain.Store;

// 모든 field 가 private final 이고 동시에 getter 가 전부 있다면 레코드로 변경가능
// recode classname(...field) 생성자
public record StoreRequest
        (String storeName, String storeAddress, int storeOpentime, int storeClosetime) {
    public Store toStore() {
        return new Store(storeName, storeAddress, storeOpentime, storeClosetime);
    }
}
