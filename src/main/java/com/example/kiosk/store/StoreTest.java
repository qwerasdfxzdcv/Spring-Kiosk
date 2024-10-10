package com.example.kiosk.store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store("매머드", "서울", 7, 21);
        Store store2 = new Store("깐부", "서울", 11, 1);
        if(store.getStoreId()!=1 && store.getStoreName().equals("매머드"))
            System.out.println("매머드 커피가 틀렸습니다.");
        if(store2.getStoreId()!=2 && store2.getStoreName().equals("깐부"))
            System.out.println("깐부치킨이 틀렸습니다.");
        Store store3 = new Store("뿌웅",null,0,0);
        if(store3.getStoreId()!=3)
            System.out.println("세번째 가게가 틀렸습니다");
    }
}
