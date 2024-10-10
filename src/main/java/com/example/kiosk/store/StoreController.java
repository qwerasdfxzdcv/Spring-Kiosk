package com.example.kiosk.store;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
    restful api
    리소스(data)를 꺼내주자
    CRUD Create, Read, Update, Delete
    method GET R
           POST C
           PUT(POST) U body(O)
           DELETE(GET) D body(X)

    url 설계
    전체 스토어를 가져온다. ( endpoint 를 /stores <-복수형) (GET)
    스토어에 추가한다 (/stores) (POST)
    스토어 안에 id=1 번 인것을 가져와라. (/stores/1) (GET)
    스토어 안에 이름이 커피가 들어간 친구를 뽑아와라 (/stores?name=커피) (GET)
    1번 스토어 이름을 커피로 바꾸고싶다 (/stores/1, {name="커피","...","..."}) (PUT)
    나머지 것은 두고 일부분만 수정하는것 -> PATCH(패치)
    스토어 1번을 지운다 (/stores/1) (DELETE)

    1. URL 복수형만 사용
    2. 명사만 사용ㅇ
    3. 소문자로 작성
    4. 언더바(_) 대신 하이픈(-) 사용
 */

@RestController
public class StoreController {
    @GetMapping
    public List<Store> getAllStores() {
        return Utils.stores;
    }
    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable int id) {
        // Optional<> <- 혹시라도 null 이 될 수 있는 값일때 사용
        Optional<Store> first = Utils.stores
                .stream()
                .filter(el -> el.getStoreId() == id)
                .findFirst();
        // 비어 있을경우 에러 발생 <- 검사하는 부분 있을경우 더욱 단단한 코드
        if(first.isEmpty()) throw new RuntimeException();
        return first.get();
    }
    @DeleteMapping("/{id}")
    public void deleteStoreById(@PathVariable int id) {
        Store store = getStoreById(id);
        Utils.stores.remove(store);
    }
    @PutMapping("/{id}")
    public Store updateStoreById(@PathVariable int id, @RequestBody StoreRequest request) {
        return getStoreById(id).update(request);
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
