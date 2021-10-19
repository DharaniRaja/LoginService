package com.dharani.loginservice.controller;

import com.dharani.loginservice.model.LoginModel;
import com.dharani.loginservice.model.User;
import com.dharani.loginservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/get")
    public User getLoginData(@RequestBody final LoginModel loginModel)
    {
      final   User users =  loginService.checkUser(loginModel);
        return users;
    }
}
