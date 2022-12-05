package com.client.bootadmintest.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
//@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

//    protected Account() {};

//    @Builder
//    public Account(Long id, String username, String password, String email){
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//    };

    @Id
//    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String email;

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

}
