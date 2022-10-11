package com.practice.mongotest.service;

import com.practice.mongotest.domain.Board;
import com.practice.mongotest.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
public class mongoDBService {

//    @Autowired
    private final BoardRepository boardRepository;

    public void mongoDBConn() {
//        BoardRepository boardRepository = null;

//        Board board = Board.builder()
//                ._id("123")
//                .title("title")
//                .content("content")
//                .build();
//
//        boardRepository.save(board).get_id();
    }
}
