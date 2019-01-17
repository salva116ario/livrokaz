package co.simplon.livrokaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.CommandLine;
import co.simplon.livrokaz.model.Customer;

public interface CommandLineRepository extends JpaRepository<CommandLine, Integer>{

	List<CommandLine> findByCustomer(Customer customerId);

}
