package com.example.demo;

import com.example.demo.entity.workhours;
import com.example.demo.repository.MemberCrudRepository;
import com.example.demo.workHours.SetDateTime;
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
	@Qualifier("Insert")
	InsertDateTime insertDateTime;

	@Autowired
	@Qualifier("SetDateTime")
	SetDateTime setDateTime;

	private void execute() {

		String start_date = setDateTime.getStart_date();
		String end_date = setDateTime.getEnd_date();
		String start_time = setDateTime.getStart_time();
		String end_time = setDateTime.getEnd_time();

		insertDateTime.insert(start_date, end_date, start_time, end_time);
	}

	private void executeSelect() {
		System.out.println("전체 데이터를 취득합니다.");
		Iterable<workhours> workHours = repository.findAll();

		for(workhours workHour : workHours) {
			System.out.println(workHour);
		}
	}
}
