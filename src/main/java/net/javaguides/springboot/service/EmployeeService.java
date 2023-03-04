package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	void save(Employee employee);
	Employee getById(Long id);
	void deleteViaId(long id);
}
