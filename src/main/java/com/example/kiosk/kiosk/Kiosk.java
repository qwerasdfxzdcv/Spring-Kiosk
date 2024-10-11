package com.example.kiosk.kiosk;

import ch.qos.logback.core.util.StringUtil;
import com.example.kiosk.store.Store;
import com.example.kiosk.store.StoreRequest;
import com.example.kiosk.store.Utils;

public class Kiosk {
    private final int kioskId;
    private final Store store;
    private int kioskNumber = 1;
    private boolean active;
    private boolean isDeleted;

    public Kiosk(int storeId) {
        this.kioskId = Utils.kioskCount++;
        this.store = Utils.stores.get(storeId-1);
        this.active = true;
        this.isDeleted = false;
        this.kioskNumber = store.incresKioskCount();
    }

    public void error(){
        active = false;
    }

    public int getKioskId() {
        return kioskId;
    }

    public int getKioskNumber() {
        return kioskNumber;
    }

    public Store getStore() {
        return store;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void kioskDelete(){
        isDeleted = true;
    }
}

