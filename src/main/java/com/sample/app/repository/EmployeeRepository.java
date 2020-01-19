package com.sample.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.app.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    List<Employee> findAll();
}
