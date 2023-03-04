package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	void save(Employee employee);
	Employee getById(Long id);
	void deleteViaId(long id);
	Page<Employee> findPaginated(int pageNo, int pageSize);
}
