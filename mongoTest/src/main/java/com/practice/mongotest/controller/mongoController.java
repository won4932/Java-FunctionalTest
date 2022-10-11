package com.practice.mongotest.controller;

import com.practice.mongotest.domain.Board;
import com.practice.mongotest.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class mongoController {

    private final BoardRepository boardRepository;

    @GetMapping("/mongotest")
    public void mongoTest() {
//        Board board = Board.builder()
//                .name("name")
//                .title("title")
//                .content("content")
//                .build();
//
//        boardRepository.save(board);

        boardRepository
                .findAll()
                .stream()
                .forEach(b -> System.out.println(b.getName()));

        System.out.println(boardRepository.findById(new ObjectId("63103244d2a13e4188198b6f"))
                .orElse(null));

    }

    @GetMapping("/mongoSelect/{id}")
    public Board mongoFindById(@PathVariable ObjectId id) {
        return boardRepository.findById(id).get();
    }

    @PostMapping("/mongoSave")
    public Board mongoSave(@RequestBody Board dto) {
        Board boardDTO = boardRepository.save(Board.builder()
                .name(dto.getName())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build());
        return boardDTO;
    }
}
