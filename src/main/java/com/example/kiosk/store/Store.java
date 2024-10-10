package com.example.kiosk.store;

import ch.qos.logback.core.util.StringUtil;

// 가게 1번
// name : 매머드 커피
// address : 서울
// opentime : 7
// closetime : 21
// id : 1
// 가게 2번
// name : 깐부치킨
// address : 서울
// opentime : 11
// closetime : 1
// id : 2
public class Store {
    private String storeName;
    private String storeAddress;
    private int storeOpentime;
    private int storeClosetime;
    private final int storeId;
    public Store update(StoreRequest request){
        if(!StringUtil.isNullOrEmpty(request.storeName()))
            storeName = request.storeName();
        if(!request.storeAddress().isEmpty())
            this.storeAddress = request.storeAddress();
        return this;
    }

    public Store(String storeName, String storeAddress, int storeOpentime, int storeClosetime) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeOpentime = storeOpentime;
        this.storeClosetime = storeClosetime;
        this.storeId = ++Utils.storeCount;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public int getStoreOpentime() {
        return storeOpentime;
    }

    public int getStoreClosetime() {
        return storeClosetime;
    }

    public int getStoreId() {
        return storeId;
    }
}
