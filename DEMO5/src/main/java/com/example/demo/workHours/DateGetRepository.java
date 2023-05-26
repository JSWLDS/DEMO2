package com.example.demo.workHours;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("date")
public interface DateGetRepository extends DateRepository {

}
