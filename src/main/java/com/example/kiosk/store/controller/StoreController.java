package com.example.kiosk.store.controller;

import com.example.kiosk.store.domain.Store;
import com.example.kiosk.store.exception.StoreNotFoundException;
import com.example.kiosk.store.request.StoreRequest;
import com.example.kiosk.store.request.StoreResponse;
import com.example.kiosk.store.service.StoreServiceImpl;
import com.example.kiosk.store.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    http 통신 상에서
    성공했다. 실패했다. 하긴 했는데 변화가 없다.
    -> 이러한 것을 표시하기 위해 status code 로 표현함
    100 =<  >200 socket
    200 =<  >300 http 통신 (대부분 성공)
    300 =<  >400 html 사용 시 (Found, Redirect)
    400 =<  >500 클라이언트 실수 (404 not found, 401 권한 없음)
    500 =<  >600 서버측 실수 (500 internal server error)
 */
@RequestMapping("/stores")
@RestController
public class StoreController {
    private final StoreServiceImpl storeServiceImpl;
    public StoreController(StoreServiceImpl storeServiceImpl) {
        this.storeServiceImpl = new StoreServiceImpl();
    }
    @GetMapping
    public List<StoreResponse> getAllStores() {
        return storeServiceImpl.getAllStores();
    }
    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable int id) {
        // Optional<> <- 혹시라도 null 이 될 수 있는 값일때 사용
        return  Utils.stores
                .stream()
                .filter(el -> el.getStoreId() == id)
                .findFirst()
                .orElseThrow(()->new StoreNotFoundException(id));
        // 비어 있을경우 에러 발생 <- 검사하는 부분 있을경우 더욱 단단한 코드
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
    @ResponseStatus(HttpStatus.CREATED)
    public Store saveStore(
        @RequestBody StoreRequest request
    ) {
        Store store = request.toStore();
        Utils.stores.add(store);
        return store;
    }
}
