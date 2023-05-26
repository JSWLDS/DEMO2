package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Employee, Integer> {

}
