package com.dharani.loginservice.service;

import com.dharani.loginservice.model.LoginModel;
import com.dharani.loginservice.model.User;
import com.dharani.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.env.Environment;


@Service
public class LoginServiceImpl implements LoginService{
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final Environment environment;

    public LoginServiceImpl(UserRepository userRepository, Environment environment) {
        this.userRepository = userRepository;
        this.environment = environment;
    }

    @Override
    public User checkUser(final LoginModel loginModel) {

        User userByEmail = userRepository.findUserByEmail(loginModel.getEmail());
        if (userByEmail!=null && loginModel.getPassword().equals(userByEmail.getPassword()) && loginModel.getEmail().equals(userByEmail.getEmail())) {
            String url = "http://localhost:8086/user/login/{email}";
            User forObject = restTemplate.getForObject(url, User.class, loginModel.getEmail());
            return forObject;
        }
        return null;
    }
}

