package com.example.kiosk.store.exception;

public class StoreNotFoundException extends IllegalArgumentException {
    public StoreNotFoundException(int id) {
        super(id + " IS NOT FOUND!!");
    }
}
