package com.example.demo.repository;

import com.example.demo.entity.WorkHours;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CRUD")
public interface MemberCrudRepository extends CrudRepository<WorkHours, Integer> {

}
