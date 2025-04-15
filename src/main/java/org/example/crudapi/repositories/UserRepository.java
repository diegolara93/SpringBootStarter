package org.example.crudapi.repositories;

import org.example.crudapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /*
    Hibernate will automatically generate the implementation of this interface
    which provides CRUD operations on the database.
     */
}
