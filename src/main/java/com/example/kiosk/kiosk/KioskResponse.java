package com.example.kiosk.kiosk;

import com.example.kiosk.store.domain.Store;

public record KioskResponse (int kioskId, int kioskNumber, Store store, boolean isActive) {
    public static KioskResponse from(Kiosk kiosk) {
        return new KioskResponse(
                kiosk.getKioskId(),
                kiosk.getKioskNumber(),
                kiosk.getStore(),
                kiosk.isActive()
        );
    }
}
