package com.example.demo;

import com.example.demo.entity.WorkHours;
import com.example.demo.repository.MemberCrudRepository;
import com.example.demo.workHours.DateGetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component("insert")
public class InsertDateTime {

    @Autowired
    @Qualifier("date")
    DateGetRepository dateGetRepository;

    @Autowired
    @Qualifier("CRUD")
    MemberCrudRepository repository;


    public void insert(){
        String start_date = "2023-01-01";
        String end_date = "2023-04-30";

        String start_time = "09:30";
        String end_time = "10:30";

        List<LocalDate> dateList = dateGetRepository.getDatesBetweenTwoDates(start_date, end_date);
        List<LocalTime> timeList = dateGetRepository.getDatesBetweenTwoTimes(start_time, end_time);

        int dateSize = dateList.size();
        int timeSize = dateList.size();

        for(int i = 0; i < 10000; i++) {

            for(int j = 0; j < dateList.size(); j++) {

                int d_random = (int) (Math.random() * dateSize);
                int t_random = (int) (Math.random() * timeSize);
                Timestamp start_date_time = reduceLocalDateTime(LocalDateTime.of(dateList.get(d_random), timeList.get(t_random)));

                Timestamp end_date_time = reduceLocalDateTime(LocalDateTime.of(dateList.get(d_random), timeList.get(t_random)));
                executeInsert(i+1, start_date_time,  end_date_time);
            }
        }
        // 전체 취득
//		executeSelect();
        System.out.println("sucessful");
    }
    private Timestamp reduceLocalDateTime(LocalDateTime of) {
        return Timestamp.valueOf(of);
    }

    private void executeInsert(int i, Timestamp star_date, Timestamp end_date) {

        WorkHours workHour = new WorkHours(null, i, star_date, end_date);
        workHour = repository.save(workHour);
//
//		System.out.println("등록 데이터 : " + workHour);
    }

}
