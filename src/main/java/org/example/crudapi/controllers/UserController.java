package org.example.crudapi.controllers;

import org.example.crudapi.models.User;
import org.example.crudapi.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController
{
    private UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/userById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("User not found with id " + id)
        );
    }

    @GetMapping("/userByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return userRepository.findByName(name)
                .orElseThrow(
                        () -> new RuntimeException("User not found with name " + name)
                );
    }

    @PostMapping("/create")
    public @ResponseBody String createUser(@RequestParam String name,
                                     @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "User created";
    }

    @PatchMapping("/update/{name}")
    public @ResponseBody String updateUser(@PathVariable String name,
                                     @RequestParam String email) {
        User n = userRepository.findByName(name)
                .orElseThrow(
                        () -> new RuntimeException("User not found with name " + name)
                );
        n.setEmail(email);
        userRepository.save(n);
        return "User updated";
    }

}
