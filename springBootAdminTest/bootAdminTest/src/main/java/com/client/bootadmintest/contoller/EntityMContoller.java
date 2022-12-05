package com.client.bootadmintest.contoller;

import com.client.bootadmintest.dao.EntityManagerDAO;
import com.client.bootadmintest.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EntityMContoller {

    private final EntityManagerDAO dao;

    private final TestService testService;

    @RequestMapping(value="/test/create", method = RequestMethod.GET)
    public void createAccount() {
//        dao = new EntityManagerDAO();
        dao.coreTest();
    }

    @RequestMapping(value="/test/select", method = RequestMethod.GET)
    public void selectAccount() {
//        dao = new EntityManagerDAO();
        dao.entityFind(2);
    }

    @RequestMapping(value="/test/selectService", method = RequestMethod.GET)
    public void selectServiceAccount() {
//        dao = new EntityManagerDAO();
//        dao.entityFind();
        testService.entityService();
//        ts.entityService();
//         return ts.entityService();
    }

    @RequestMapping(value="/test/del", method = RequestMethod.GET)
    public void deleteCache() {
//        dao = new EntityManagerDAO();
        dao.entityCacheDel();
    }
}
