package com.example.demo.service;

import com.example.demo.persistance.entity.User;
import com.example.demo.persistance.repository.UserRepository;
import com.example.demo.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> getUsersPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> pageResult = userRepository.findAll(pageRequest);
        List<User> users = pageResult
                .stream()
                .collect(toList());
        return new PageImpl<>(users, pageRequest, pageResult.getTotalElements());
    }

    @Override
    public Optional<User> getById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        return userRepository.save(convertUserDTOtoUser(userDTO));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    private User convertUserDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
