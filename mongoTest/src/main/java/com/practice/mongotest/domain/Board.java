package com.practice.mongotest.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
@AllArgsConstructor
@ToString
@Document
public class Board {

    @Id
    @Field("_id")
    private ObjectId id;
    private String name;
    private String title;
    private String content;
}
