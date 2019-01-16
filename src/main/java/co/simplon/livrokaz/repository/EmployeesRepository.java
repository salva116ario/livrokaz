package co.simplon.livrokaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.Employees;
import co.simplon.livrokaz.model.Role;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>{

	Iterable<Employees> findByRole(Role role);

}
