package co.simplon.livrokaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
