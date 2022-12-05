package com.client.bootadmintest.service;

import com.client.bootadmintest.dao.EntityManagerDAO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class TestService {

    private final EntityManagerDAO dao;

    public String testS() {
        return "hello2";
    }

    public void entityService() {
//        dao = new EntityManagerDAO();
        for(int i = 0; i<5; i++) {
            dao.entityFind(2);
        }

        SimpleCacheManager scm = new SimpleCacheManager();
        System.out.println(scm.getCache("test"));

//        System.out.println("Cache it? A : " + dao.entityFind(2));

//        System.out.println("Cache it? B : " + dao.entityFind(2));

//        dao.entityFind(2);
//        return dao.entityFind(2);

    }

    public void entityCacheDelete() {
//        dao = new EntityManagerDAO();

        dao.entityCacheDel();
    }

}
