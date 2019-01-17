package co.simplon.livrokaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.Employee;
import co.simplon.livrokaz.model.Role;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Iterable<Employee> findByRole(Role role);

}
