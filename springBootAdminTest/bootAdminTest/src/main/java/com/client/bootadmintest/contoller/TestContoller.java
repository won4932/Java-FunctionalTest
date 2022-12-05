package com.client.bootadmintest.contoller;

import com.client.bootadmintest.service.SplitTest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
@RequiredArgsConstructor
public class TestContoller {

    private final SplitTest sp;

    @RequestMapping(value="/test/split", method = RequestMethod.GET)
    public void createAccount() {

        sp.splitRest();
    }

    @RequestMapping(value="/test/date", method = RequestMethod.GET)
    public void calendarTest() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
        cal.set(2022, 07, 29);

        System.out.println(cal.get(Calendar.MONTH));

        cal.add(Calendar.YEAR, -1);

        System.out.println(cal);

        System.out.println(cal.getTimeInMillis());

        int ll = 1234;

        Timestamp t = new Timestamp(ll);

        System.out.println(t);
//        long s = 0;
//        for(int i = 0; i<10; i++) {
//            s += 1630204788;
//        }

    }

}
