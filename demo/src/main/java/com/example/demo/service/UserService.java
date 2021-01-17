package com.example.demo.service;

import com.example.demo.persistance.entity.User;
import com.example.demo.web.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User saveUser(UserDTO userDTO);

    void deleteUser(int id);

    Optional<User> getById(int userId);

    Page<User> getUsersPage(int page, int size);

    List<User> getUsers();
}
