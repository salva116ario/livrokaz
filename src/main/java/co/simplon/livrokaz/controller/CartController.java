package co.simplon.livrokaz.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Book;
import co.simplon.livrokaz.model.CommandLine;
import co.simplon.livrokaz.model.Customer;
import co.simplon.livrokaz.model.Orders;
import co.simplon.livrokaz.repository.CommandLineRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CommandLineRepository commandLineRepository;

	@Autowired
	private BookController bookController;

	@Autowired
	private OrdersController ordersController;

	@Autowired
	private CommandLineController commandLineController;

	/**
	 * Ajoute {quantity} exemplaire(s) du livre {book} au panier de {customer}
	 * 
	 * @param customer
	 * @param book
	 * @param quantity
	 * @return
	 */
	@PostMapping(value = "/addbook/{customer}/{book}/{quantity}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addInCart(@PathVariable Customer customer, @PathVariable Book book,
			@PathVariable int quantity) {
		Date date = new Date();
		try {
			CommandLine commandLine = new CommandLine();
			commandLine.setBook(book);
			commandLine.setCustomer(customer);
			commandLine.setClQuantity(quantity);
			commandLine.setClDate(date);
			commandLine.setClStatus(false);
			commandLineController.addCommandLine(commandLine);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	/**
	 * Valide un panier : crée une une commande reliée aux lignes de commandes du
	 * panier dont le statut passe à true.
	 * Met à jour le stock dans la table book.
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping(value = "/validate/{customer}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> validateCart(@PathVariable Customer customer) {
		try {
			Set<CommandLine> commandLines = new HashSet<>(0);
			commandLines = commandLineRepository.findByCustomerAndClStatus(customer, false);
			Date date = new Date();
			Orders orders = new Orders(customer, false, date, 0, 0, commandLines);
			ordersController.addOrder(orders);
			float totalPrice = 0;
			for (CommandLine commandLine : commandLines) {
				totalPrice += commandLine.getBook().getBoPrice() * commandLine.getClQuantity();
				int stock = commandLine.getBook().getBoStock() - 1;
				commandLine.getBook().setBoStock(stock);
				bookController.modifyBook(commandLine.getBook());
				commandLine.setClStatus(true);
				commandLine.setOrders(orders);
				commandLineController.modifyCommandLine(commandLine);
			}
			orders.setOrTotalCost(totalPrice);
			ordersController.modifyOrder(orders);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

}
