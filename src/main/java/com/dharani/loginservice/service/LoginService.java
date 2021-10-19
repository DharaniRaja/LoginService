package com.dharani.loginservice.service;

import com.dharani.loginservice.model.LoginModel;
import com.dharani.loginservice.model.User;


import java.util.List;

public interface LoginService {
    User checkUser(LoginModel loginModel);
}
