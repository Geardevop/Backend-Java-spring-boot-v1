package com.usrapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usrapi.demo.exception.ResourceNotFoundException;
import com.usrapi.demo.model.User;
import com.usrapi.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
        private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        
        // Update user properties
        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setWebsite(userDetails.getWebsite());
        
        // Update address if provided
        if (userDetails.getAddress() != null) {
            user.setAddress(userDetails.getAddress());
        }
        
        // Update company if provided
        if (userDetails.getCompany() != null) {
            user.setCompany(userDetails.getCompany());
        }
        
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

}
