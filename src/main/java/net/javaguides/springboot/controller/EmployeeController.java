package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.springboot.model.Employee;

@Controller
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allemplist", employeeService.getAllEmployee());
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
