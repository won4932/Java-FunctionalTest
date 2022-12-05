package com.client.bootadmintest.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Configuration
@Slf4j
public class EntityManagerComponent {

//    @Primary
//    @Bean
//    public CacheManager cacheManager2() {
//
//        SimpleCacheManager scm = new SimpleCacheManager();
//        scm.setCaches(List.of(new ConcurrentMapCache("test"), new ConcurrentMapCache("test2")));
//
//        System.out.println("################################ CacheManager Start!");
//        return scm;
//    }
//
//    @Bean
//    public CacheManager InsertCacheManager2() {
//
//        SimpleCacheManager scm = new SimpleCacheManager();
//        scm.setCaches(List.of(new ConcurrentMapCache("EntityInsert1"), new ConcurrentMapCache("EntityInsert2")));
//
//        System.out.println("################################ CacheManager Start!");
//        return scm;
//    }











//    private EntityManagerFactory enf;


//    @PostConstruct
//    public void createEntityFactory() {
//        enf = Persistence.createEntityManagerFactory("hello");
//    }
//
//    @PreDestroy
//    public void destroyEntityFactory() {
//        if(enf.isOpen()) enf.close();
//    }

//    @Bean
//    public void persistencyConfig() {
////        LocalEntityManagerFactoryBean lemfb = new LocalEntityManagerFactoryBean();
////        LocalContainerEntityManagerFactoryBean l = new LocalContainerEntityManagerFactoryBean();
////
////        lemfb.setPersistenceUnitName("core-test");
////        HibernateJpaVendorAdapter
////        System.out.println("PersistenceUnitName Create!");
//
//
//    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
//    //    private DataSource dataSource;
////
////    @Autowired
////    public SpringConfig(DataSource dataSource) {
////        this.dataSource = dataSource;
////    }
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
}
