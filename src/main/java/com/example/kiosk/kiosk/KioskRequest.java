package com.example.kiosk.kiosk;

import com.example.kiosk.store.Store;

public record KioskRequest(int storeId) {
    public Kiosk toKiosk() {
        return new Kiosk(storeId);
    }
}
