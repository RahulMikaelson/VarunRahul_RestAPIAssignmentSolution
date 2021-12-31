package com.greatlearning.EmployeeManagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.service.EmployeeService;



@Controller
@RequestMapping("/employee")
public class EmployeeManagementController {
	@Autowired
	private EmployeeService stdservice;

	// add mapping for "/list"
	@RequestMapping("/list")
	public String listEmployee(Model model) {
		// get Students from DB
		List<Employee> std = stdservice.findAll();

		// add to the spring model
		model.addAttribute("Employee", std);
		return "/employee";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create model attribute to bind form data
		Employee theEmp = new Employee();

		model.addAttribute("Employee", theEmp);

		return "Employee-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {

		
		Employee theemp = stdservice.findById(theId);

		
		model.addAttribute("Employee", theemp);

		// send over to our form
		return "Employee-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("First Name") String f_name,
			@RequestParam("Last Name") String l_name) {

		System.out.println(id);
		Employee stddet = new Employee();
		if (id != 0) {
			stddet.setF_name(f_name);
			stddet.setL_name(l_name);			

		} else
			stddet = new Employee(f_name, l_name);
		// save the student
		stdservice.save(stddet);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employee/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// delete the Book
		stdservice.deleteById(theId);

		
		return "redirect:/employee/list";

	}

	@RequestMapping("/search")
	public String search(@RequestParam("First Name") String f_name, Model theModel) {

		// check names, if both are empty then just give list of all Books

		if (f_name.trim().isEmpty() ) {
			return "redirect:/employee/list";
		} else {
			// else, search by first name and last name
			List<Employee> theemployee = stdservice.searchBy(f_name);

			// add to the spring model
			theModel.addAttribute("Employee", theemployee);

			// send to list-Books
			return "employee/list";
		}

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
