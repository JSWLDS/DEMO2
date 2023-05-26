package com.example.demo.workHours;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public interface DateRepository {
     default List<LocalDate> getDatesBetweenTwoDates(String startDate, String endDate) {

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate start_date = LocalDate.parse(startDate, formatter);
        LocalDate end_date = LocalDate.parse(endDate,formatter);


        int numOfDaysBetween = (int) ChronoUnit.DAYS.between(start_date, end_date)+1;
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> start_date.plusDays(i))
                .collect(Collectors.toList());
    }

    default List<LocalTime> getDatesBetweenTwoTimes(String startTime, String endTime) {

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm");

        LocalTime start_time = LocalTime.parse(startTime, formatter);
        LocalTime end_time = LocalTime.parse(endTime,formatter);


        int numOfDaysBetween = (int) ChronoUnit.MINUTES.between(start_time, end_time)+1;
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> start_time.plusMinutes(i))
                .collect(Collectors.toList());
    }

}
