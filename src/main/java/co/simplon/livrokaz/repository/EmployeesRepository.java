package co.simplon.livrokaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>{

}
