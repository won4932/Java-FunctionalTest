package com.client.bootadmintest.service;

import com.client.bootadmintest.Entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService {

    private static final Account EMPTY_DATA = new Account();

    @Cacheable(cacheNames = "exampleCache", key = "#key")
    public Account getCacheData(final String key) {
        log.info("이 로그는 해당 key에 대한 캐시가 없는 경우 찍힙니다.");
        return EMPTY_DATA;
    }

    @CachePut(cacheNames = "exampleCache", key = "#key")
    public Account updateCacheData(final String key, final String value) {
        log.info("이 로그는 해당 key에 대한 캐시가 업데이트 되는 경우 찍힙니다.");
        Account ac = new Account();
        return ac;
    }
}
