package com.example.demo.workHours;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SetDateTime")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class SetDateTime {
    String start_date = "2023-01-01";
    String end_date = "2023-04-30";

    String start_time = "09:30";
    String end_time = "10:30";
}
