package com.sample.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.app.model.Employee;
import com.sample.app.repository.EmployeeRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class App {

	private static final Logger logger = LogManager.getLogger(App.class);

	private static void printEmployee(Employee emp) {
		System.out.println("------------------------------");
		System.out.println("Id : " + emp.getId());
		System.out.println("firstName : " + emp.getFirstName());
		System.out.println("lastName : " + emp.getLastName());
		System.out.println("------------------------------");
	}

	public static void main(String args[]) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository employeeRepository) {
		return (args) -> {
			Employee emp1 = Employee.builder().firstName("Ram").lastName("Gurram").build();
			Employee emp2 = Employee.builder().firstName("Shiney").lastName("Soo").build();
			Employee emp3 = Employee.builder().firstName("Mahesh").lastName("Bhat").build();
			Employee emp4 = Employee.builder().firstName("Rahim").lastName("Chelli").build();

			Employee persistedEntity1 = employeeRepository.save(emp1);
			Employee persistedEntity2 = employeeRepository.save(emp2);
			Employee persistedEntity3 = employeeRepository.save(emp3);
			Employee persistedEntity4 = employeeRepository.save(emp4);




			Iterable<Employee> iterable = employeeRepository.findAll();

			logger.debug("Debugging log");
			logger.info("Info log");
			logger.warn("Hey, This is a warning!");
			logger.error("Oops! We have an Error. OK");
			logger.fatal("Damn! Fatal error. Please fix me.");

			logger.info("Printing all the employees in db with findAll");


			for (Employee employee : iterable) {
				printEmployee(employee);
			}



			List<Integer> ids = Arrays.asList(232, persistedEntity1.getId(), persistedEntity3.getId(), 56, 90);

			Iterable<Employee> emps = employeeRepository.findAllById(ids);

			logger.info("Printing all the employees in db with findAllById");
			for (Employee emp : emps) {
				printEmployee(emp);
			}

		};
	}

}

