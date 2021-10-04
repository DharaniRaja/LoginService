package com.dharani.loginservice.controller;

import com.dharani.loginservice.model.LoginModel;
import com.dharani.loginservice.model.User;
import com.dharani.loginservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/get")
    public List<User> getLoginData(@RequestBody LoginModel loginModel)
    {
        List<User> users = loginService.checkUser(loginModel);
        for(int i=0;i<users.size();i++)
        {
            System.out.println(users.get(i));
        }
        return users;
    }
}
