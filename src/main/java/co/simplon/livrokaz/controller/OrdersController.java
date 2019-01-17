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

import co.simplon.livrokaz.model.Customer;
import co.simplon.livrokaz.model.Orders;
import co.simplon.livrokaz.repository.OrdersRepository;

@RestController
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@GetMapping("/orders")
	public ResponseEntity<?> getAllOrders(){
		List<Orders> ordersList = null;
		try {
			ordersList = ordersRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(ordersList);
	}
	
	/**
	 * Retourne un order avec id = {id}
	 * @param id
	 * @return
	 */
	@GetMapping("/orders/id/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable Integer id) {
		Optional<Orders> order = null;
		try {
			order = ordersRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	/**
	 * Retourne un order avec un id de customer = {id}
	 * @param id
	 * @return
	 */
	@GetMapping("/orders/customer/{customerId}")
	public ResponseEntity<?> getOrderByCustomer(@PathVariable Customer customerId) {
		Optional<Orders> order = null;
		try {
			order = ordersRepository.findByCustomer(customerId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	/**
	 * Ajouter un order 
	 * @param orders
	 * @return
	 */
	@PostMapping(value = "/admin/addorder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addOrder(@RequestBody Orders order) {
		Orders orderToAdd = null;
		try {
			orderToAdd = ordersRepository.saveAndFlush(order);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(orderToAdd);
	}
	
	/**
	 * modifier un order
	 * @param customer
	 * @return
	 */

	@PutMapping(value = "/admin/modifyorder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyOrder(@RequestBody Orders order) {
		Orders orderToModify = null;
		try {
			orderToModify = ordersRepository.saveAndFlush(order);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(orderToModify);
	}
	
	/**
	 * supprimer un order
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/admin/deleteorder/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
		try {
			ordersRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
