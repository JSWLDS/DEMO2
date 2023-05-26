package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkHours {

    @Id
    private Integer work_id;

    private Integer emp_id;

    private Timestamp start_date;

    private Timestamp end_date;

}
