package com.example.kiosk.store.config;

import com.example.kiosk.store.service.StoreService;
import com.example.kiosk.store.service.StoreServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @ConditionalMissingBean <- Bean 에 등록이 되어있지 않다면 사용해라
// ConditionalMissingBean 을 사용시 @Primary 를 사용하지 않아도 됨

@Configuration
public class StoreConfig {
    @Bean
    public StoreService storeService() {
        return new StoreServiceImpl();
    }
}
