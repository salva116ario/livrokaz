package co.simplon.livrokaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.User0ld;


public interface UserRepository extends JpaRepository<User0ld, Long>{

    User0ld findByUsername(String username);
    User0ld getById(Long id);
}
