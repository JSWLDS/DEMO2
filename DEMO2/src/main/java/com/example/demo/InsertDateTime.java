package com.example.demo;

import com.example.demo.entity.workhours;
import com.example.demo.repository.MemberCrudRepository;
import com.example.demo.workHours.DateGetRepository;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component("Insert")
public class InsertDateTime {

    @Autowired
    @Qualifier("date")
    DateGetRepository dateGetRepository;

    @Autowired
    @Qualifier("CRUD")
    MemberCrudRepository repository;


    public void insert(String start_date,  String end_date,  String start_time,  String end_time){

        List<LocalDate> dateList = dateGetRepository.getDatesBetweenTwoDates(start_date, end_date);
        List<LocalTime> startTimeList = dateGetRepository.getDatesBetweenTwoTimes(start_time, end_time);
        start_time = "20:00";
        end_time = "22:00";
        List<LocalTime> endTimeList = dateGetRepository.getDatesBetweenTwoTimes(start_time, end_time);

//        for(LocalTime time  : endTimeList) {
//            System.out.println(time);
//        }

        int dateSize = dateList.size();
        int startTimeSize = startTimeList.size();
        int endTimeSize = endTimeList.size();
        for(int i = 0; i < 10000; i++) {

            for(int j = 0; j < dateSize; j++) {

                int start_t_random = (int) (Math.random() * startTimeSize);
                Timestamp start_date_time = reduceLocalDateTime(LocalDateTime.of(dateList.get(j), startTimeList.get(start_t_random)));


                int end_t_random = (int) (Math.random() * endTimeSize);
                Timestamp end_date_time = reduceLocalDateTime(LocalDateTime.of(dateList.get(j), endTimeList.get(end_t_random)));
//                System.out.println(start_date_time);
//                System.out.println(end_date_time);
                  executeInsert(i+1, start_date_time,  end_date_time);
//                System.out.println(start_date_time);
            }
        }
        // 전체 취득
//		executeSelect();
        System.out.println("sucessful");
    }
    
    // 안쓰면 교착상태(?) 얼어나는듯
    @Contract("_ -> new") //직역: 계약 | - : 임의의 값, new : 이 개체느 null이 아니어야 하며, 힙에 있는 다른 개체와 달라야 한다. | 형식 : @Contract("입력 값 형식 -> 반환 값 형식")
    private @NotNull/* null을 허용하지 않음 */ Timestamp reduceLocalDateTime(LocalDateTime of) {
        return Timestamp.valueOf(of);
    }

    private void executeInsert(int i, Timestamp start_date, Timestamp end_date) {

        workhours workHour = new workhours((Long) null, (long) i, start_date, end_date);
        workHour = repository.save(workHour);
//
//		System.out.println("등록 데이터 : " + workHour);
    }

}
