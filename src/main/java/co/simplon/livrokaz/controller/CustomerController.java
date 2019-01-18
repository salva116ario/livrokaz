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

import co.simplon.livrokaz.model.Customer;
import co.simplon.livrokaz.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;


	/**
	 * Retourne tous les clients
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> customerList = null;
		try {
			customerList = customerRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(customerList);
	}

	/**
	 * Retourne le client avec id = {id}
	 * @param id
	 * @return
	 */
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Integer id) {
		Optional<Customer> customer = null;
		try {
			customer = customerRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}

	/**
	 * Retourne les clients dont le nom contient {name}
	 * @param name
	 * @return
	 */
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<?> getCustomerByName(@PathVariable String name) {
		Iterable<Customer> customerList = null;
		try {
			customerList = customerRepository.findByCuNameContainingIgnoreCase(name);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(customerList);
	}

	/**
	 * Ajoute un client
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		Customer customerToAdd = null;
		try {
			customerToAdd = customerRepository.saveAndFlush(customer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(customerToAdd);
	}

	/**
	 * Modifie un client
	 * @param customer
	 * @return
	 */
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyCustomer(@RequestBody Customer customer) {
		Customer customerToAdd = null;
		try {
			customerToAdd = customerRepository.saveAndFlush(customer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(customerToAdd);
	}

	/**
	 * Supprime le client avec id = {id}
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
		try {
			customerRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
