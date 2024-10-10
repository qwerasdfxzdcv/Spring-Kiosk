package com.example.kiosk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/*
    react, vue, next, nuxt 와 같은 front-end framework 가 많이 때문에
    fe를 아예 분리하는 것이 좋다. 사유: 성능이슈, 편함

    ??? 그럼 이런 spring 은 어디다 써먹나요 ???
        => data 전달
        ex) react 에서 통신요청을 하면 -> spring 에서 data(json)를 받아감
    @Controller view 를 꺼내준다 -> html 을 꺼내온다
 */

@RestController // @Controller + @ResponseBody = @RestController
public class TestController {
    // @RequestMapping(value = "/java", method = RequestMethod.GET)
    // 매번 method = RequestMethod.GET 적기 싫어서 GetMapping 간단하게 적음
    @GetMapping(value = "/sleep")
    public String sleep() throws InterruptedException {
        Thread.sleep(10000); //페이지가 10초후에 출력됨
        return "sleep";
    }
    // get 메소드로 /name 으로 이름 출력하는 것
    // API - application programing interface(접점)
    @GetMapping(value = "/name") // "/name" 이라는 엔드포인트를 설정한 것
    //@ResponseBody  엔드포인트를 계속해서 만들수록 ResponseBody 의 개수도 늘어난다 그래서 맨 위에 하나만 쓴다
    public String name(){
        return "최승혁";
    }
}
