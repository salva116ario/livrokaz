package co.simplon.livrokaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Customer;
import co.simplon.livrokaz.repository.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public ResponseEntity<?> getAllCustomers(){
		List<Customer> customerList = null;
		try {
			customerList = customerRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(customerList);
	}
}
