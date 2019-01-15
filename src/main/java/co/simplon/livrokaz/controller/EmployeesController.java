package co.simplon.livrokaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Employees;
import co.simplon.livrokaz.repository.EmployeesRepository;

@RestController
public class EmployeesController {
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees(){
		List<Employees> employeesList = null;
		try {
			employeesList = employeesRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(employeesList);
	}
	
}
