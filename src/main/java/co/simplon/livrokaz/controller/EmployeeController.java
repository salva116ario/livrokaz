package co.simplon.livrokaz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Employee;
import co.simplon.livrokaz.model.Role;
import co.simplon.livrokaz.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * Retourne tous les employés
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<?> getAllEmployees(){
		List<Employee> employees = null;
		try {
			employees = employeeRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
	
	/**
	 * Retourne l'employé dont id = {id}
	 * @param id
	 * @return
	 */
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
		Optional<Employee> employee = null;
		try {
			employee = employeeRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	/**
	 * Retourne les employés selon le rôle
	 * (dans l'url, {role} correspond à l'identifiant du rôle recherché
	 * @param role
	 * @return
	 */
	@GetMapping("/getbyrole/{role}")
	public ResponseEntity<?> getEmployeesByRole(@PathVariable Role role) {
		Iterable<Employee> employees = null;
		try {
			employees = employeeRepository.findByRole(role);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
	
	/**
	 * Ajoute un employé
	 * @param employee
	 * @return
	 */	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		Employee employeeToAdd = null;
		try {
			employeeToAdd = employeeRepository.saveAndFlush(employee);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeToAdd);
	}
	
	/**
	 * Modifie un employé
	 * @param employee
	 * @return
	 */
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyEmployee(@RequestBody Employee employee) {
		Employee employeeToModify = null;
		try {
			employeeToModify = employeeRepository.saveAndFlush(employee);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeToModify);
	}
	
	/**
	 * Supprime un employé
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		try {
			employeeRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
