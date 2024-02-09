package be.tftic.spring.demo.bll.impl;


import be.tftic.spring.demo.bll.services.UserService;
import be.tftic.spring.demo.dal.UserRepository;
import be.tftic.spring.demo.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(user.getPassword(), passwordEncoder);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        if ( userRepository.existsById(id) ) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        } else {

            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return null;
    }
}

