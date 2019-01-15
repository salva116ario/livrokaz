package co.simplon.livrokaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
