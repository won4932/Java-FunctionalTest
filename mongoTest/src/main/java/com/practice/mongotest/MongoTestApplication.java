package com.practice.mongotest;

import com.practice.mongotest.domain.Board;
import com.practice.mongotest.repository.BoardRepository;
import com.practice.mongotest.service.mongoDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoTestApplication {

//    @Autowired
//    private mongoDBService dbService;
//
//    @Autowired
//    private BoardRepository boardRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoTestApplication.class, args);

//        mongoDBService service = new mongoDBService("d");
//        dbService.mongoDBConn();
    }

}
