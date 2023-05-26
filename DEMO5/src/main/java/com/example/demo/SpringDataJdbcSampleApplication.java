package com.example.demo;

import com.example.demo.entity.WorkHours;
import com.example.demo.repository.MemberCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {

	public static void main(String[] args)  {
		  SpringApplication.run(SpringDataJdbcSampleApplication.class, args).getBean(SpringDataJdbcSampleApplication.class).execute();
	}

	@Autowired
	@Qualifier("CRUD")
	MemberCrudRepository repository;
	@Autowired
	@Qualifier("insert")
	InsertDateTime insertDateTime;


	private void execute() {
		insertDateTime.insert();
	}

	private void executeSelect() {
		System.out.println("전체 데이터를 취득합니다.");
		Iterable<WorkHours> workHours = repository.findAll();

		for(WorkHours workHour : workHours) {
			System.out.println(workHour);
		}
	}
}
