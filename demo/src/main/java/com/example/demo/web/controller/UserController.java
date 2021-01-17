package com.example.demo.web.controller;

import com.example.demo.persistance.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping("addUser")
    public void addUser(@Valid @RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    @GetMapping("getUsers")
    public Page<User> list(@RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size) {
        return userService.getUsersPage(page, size);
    }


    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {

        Optional<User> user = userService.getById(id);

        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @GetMapping("getUserById/{userId}")
    public ResponseEntity<User> userById(@PathVariable int userId) {

        Optional<User> user = userService.getById(userId);
        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }
}
