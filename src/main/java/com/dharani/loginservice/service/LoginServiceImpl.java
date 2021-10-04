package com.dharani.loginservice.service;


import com.dharani.loginservice.model.LoginModel;
import com.dharani.loginservice.model.User;
import com.dharani.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    UserRepository userRepository;
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<User> checkUser(LoginModel loginModel) {
        User userByEmail = userRepository.findUserByEmail(loginModel.getEmail());
        if (userByEmail!=null) {
            String url = "http://localhost:8086/user/login";
            ResponseEntity<User[]> entity = restTemplate.getForEntity(url, User[].class);
            List<User> list = Arrays.asList(entity.getBody());

            return list;
        }
        return null;
    }
}
