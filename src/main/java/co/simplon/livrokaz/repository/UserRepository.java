package co.simplon.livrokaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);
    User getById(Long id);
}
