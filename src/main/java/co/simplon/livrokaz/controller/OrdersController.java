package co.simplon.livrokaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
