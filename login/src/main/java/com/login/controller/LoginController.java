package com.login.controller;

import com.login.model.LOGINRESPONSE;
import com.login.service.AdministratorLogin;
import com.login.service.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    AdministratorLogin al;
    @Autowired
    UserLogin ul;
    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestParam String id,@RequestParam String password){
        if (ul.login(id, password).equals(LOGINRESPONSE.SUCCESS)){
            return ResponseEntity.ok().body("登录成功");
        }
        else
            return ResponseEntity.badRequest().body("登录失败");
    }
    @RequestMapping("/administratorLogin")
    public ResponseEntity<String> administratorLogin(@RequestParam String id,@RequestParam String password){
        if (al.administratorLogin(id, password).equals(LOGINRESPONSE.SUCCESS)){
            return ResponseEntity.ok().body("登录成功");
        }
        else
            return ResponseEntity.badRequest().body("登录失败");
    }

}
