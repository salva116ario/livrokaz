package co.simplon.livrokaz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.Customer;
import co.simplon.livrokaz.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	Optional<Orders> findByCustomer(Customer customer);

}
