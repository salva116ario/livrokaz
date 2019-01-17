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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Employees;
import co.simplon.livrokaz.model.Role;
import co.simplon.livrokaz.repository.EmployeesRepository;

@RestController
public class EmployeesController {
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	/**
	 * Retourne tous les employés
	 * @return
	 */
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
	
	/**
	 * Retourne l'employé dont id = {id}
	 * @param id
	 * @return
	 */
	@GetMapping("/employees/id/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
		Optional<Employees> employee = null;
		try {
			employee = employeesRepository.findById(id);
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
	@GetMapping("/employees/role/{role}")
	public ResponseEntity<?> getEmployeesByRole(@PathVariable Role role) {
		Iterable<Employees> employees = null;
		try {
			employees = employeesRepository.findByRole(role);
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
	@PostMapping(value = "/admin/addemployee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addEmployee(@RequestBody Employees employee) {
		Employees employeeToAdd = null;
		try {
			employeeToAdd = employeesRepository.saveAndFlush(employee);
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
	@PutMapping(value = "/admin/modifyemployee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyEmployee(@RequestBody Employees employee) {
		Employees employeeToModify = null;
		try {
			employeeToModify = employeesRepository.saveAndFlush(employee);
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
	@DeleteMapping(value = "/admin/deleteemployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		try {
			employeesRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
