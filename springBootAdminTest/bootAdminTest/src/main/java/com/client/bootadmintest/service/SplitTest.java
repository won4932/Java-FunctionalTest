package com.client.bootadmintest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SplitTest {

    private static String filterDelimiter = ":#";

    private static String separator = "=";

    public void splitTest() {
        String a = "abc:#def";

        String b = "abcdef";

        try {
            System.out.println("a Split : " + a.split(":#")[1]);
        }catch(Exception e) {
            System.out.println("a Not Split");
        }


        try {
            System.out.println("b Split : " + b.split(":#")[1]);
        }catch(Exception e) {
            System.out.println("b Not Split");
        }


    }

    public void splitRest() {

        String url = "EMSREST:#dateStructure=date=s";

        String url2 = "EMSREST:#opration=timezone=timezone-1";

        String rest = url.split(filterDelimiter)[0];

        String filter = url.split(filterDelimiter)[1];

        System.out.println("A : " + filter.split(separator)[0]);

        System.out.println("b : " + filter.split(separator)[1]);

        System.out.println("c : " + filter.split(separator)[2]);
    }


}
