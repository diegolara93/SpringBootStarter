package org.example.crudapi.repositories;

import org.example.crudapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /*
    Hibernate will automatically generate the implementation of this interface
    which provides CRUD operations on the database.
     */
    @SuppressWarnings("unused")
    Optional<User> findByName(String name);
}
