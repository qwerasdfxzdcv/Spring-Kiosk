package com.example.kiosk.kiosk;

public record KioskRequest(int storeId) {
    public Kiosk toKiosk() {
        return new Kiosk(storeId);
    }
}
