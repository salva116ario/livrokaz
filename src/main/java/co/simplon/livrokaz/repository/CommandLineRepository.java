package co.simplon.livrokaz.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.CommandLine;
import co.simplon.livrokaz.model.Customer;

public interface CommandLineRepository extends JpaRepository<CommandLine, Integer>{



	Set<CommandLine> findByCustomerAndClStatus(Customer customer, boolean b);

	Set<CommandLine> findByCustomer(Customer customerId);





}
