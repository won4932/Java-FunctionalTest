package com.client.bootadmintest.dao;

import com.client.bootadmintest.Entity.Account;
import com.client.bootadmintest.component.EntityManagerComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Repository
@RequiredArgsConstructor
//@Service
public class EntityManagerDAO {

    private final EntityManagerFactory enf = Persistence.createEntityManagerFactory("hello");

//    @Autowired
//    private EntityManagerComponent enf;

    public void coreTest() {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("jpa-tutorial");
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//// Transactional hibernate and JPA code goes here
//        entityManager.getTransaction().commit();


        EntityManager em = enf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

//        JpaTransactionManager

        tx.begin();

//        Account ac = new Account(2L, "HelloA", "PassA", "HelloA.co.kr");

        Account ac = Account.builder()
                .id(2L)
                .username("HelloC")
                .password("PassC")
                .email("Hello.co.kr")
                .build();

        em.persist(ac);

        Account ac2 = em.find(Account.class, 2L);

        tx.commit();

        tx.begin();

        Account ac3 = em.find(Account.class, 2L);

        tx.commit();

        tx.begin();

        System.out.println(ac2.getEmail());


        System.out.println(ac3.getEmail());
//        Account ac = new Account();
//        ac.setId(2L);
//        ac.setUsername("TTT");
//        ac.setPassword("EEE");
//        ac.setEmail("EEE.com");




        tx.commit();

        em.close();

//        EntityManager em2 = enf.createEntityManager();
//
//        EntityTransaction tx2 = em.getTransaction();
//
//        tx2.begin();
//
//        em2
//        tx2.commit();


//        enf.close();
    }

    public String test() {
        return "hello";
    }

    @Transactional(readOnly = true)
//    @Cacheable(value = "test", key = "#entityKey")
//    @Cacheable(value="test2", key="333")
    @Cacheable("test")
    public void entityFind(Integer entityKey) {
        EntityManager em = enf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

//        for(int i = 0; i<5; i++) {
//            Account ac = em.find(Account.class, 2L);
//        }
        System.out.println("Acount Find Before : ");
        Account ac2 = em.find(Account.class, 2L);

        System.out.println("AC2 : " + ac2.getId());
        System.out.println("AC2 : " + ac2.getUsername());

//        entityCacheDel();
//
        Account ac3 = em.find(Account.class, 3L);

        System.out.println("AC3 : " + ac3.getId());
        System.out.println("AC3 : " + ac3.getUsername());
//
//        Account ac4 = em.find(Account.class, 2L);



        tx.commit();

        em.close();

//        return ac2;

//        enf.close();


    }

    @CacheEvict("test")
    public void entityCacheDel() {

    }


}
