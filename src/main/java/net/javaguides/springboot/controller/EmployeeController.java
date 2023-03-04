package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.springboot.model.Employee;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, model);
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		Page<Employee> page = employeeService.findPaginated(pageNo, 5);

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listEmployees", page.getContent());
		return "index";
	}

	@GetMapping("/addnew")
	public String addNewEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "newemployee";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model) {
		model.addAttribute("employee", employeeService.getById(id));
		return "update";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteThroughId(@PathVariable(value = "id") long id) {
		employeeService.deleteViaId(id);
		return "redirect:/";

	}
}
