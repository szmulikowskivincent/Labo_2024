package be.tftic.spring.demo.bll.services;

import be.tftic.spring.demo.domain.entities.User;


public interface AuthenticationService {

    User register(User user);
    User login(User user);
}
