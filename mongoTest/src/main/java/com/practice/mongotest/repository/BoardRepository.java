package com.practice.mongotest.repository;

import com.practice.mongotest.domain.Board;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends MongoRepository<Board, ObjectId> {

    List<Board> findByName(String name);
}
