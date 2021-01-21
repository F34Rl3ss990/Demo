package com.example.demo.service;

import com.example.demo.persistance.entity.User;
import com.example.demo.web.dto.UserDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

    User saveUser(UserDTO userDTO);

    void deleteUser(int id);

    Optional<User> getById(int userId);

    Page<User> getUsersPage(int page, int size);
}
