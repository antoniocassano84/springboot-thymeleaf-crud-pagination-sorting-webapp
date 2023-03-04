package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public void save(Employee employee) {
		empRepo.save(employee);
	}

	@Override
	public Employee getById(Long id) {
		Optional<Employee> optional = empRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		else throw new RuntimeException("Employee not found for id : " + id);
	}

	@Override
	public void deleteViaId(long id) {
		empRepo.deleteById(id);
	}
}
