package com.holiday.controller;

import com.holiday.entity.User;
import com.holiday.service.UserService;
import com.holiday.util.RestResult;
import com.holiday.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistController {

    @Autowired
    private ResultGenerator resultGenerator;

    @Autowired
    private UserService userService;

    @RequestMapping("/register_index")
    public String registIndex() {
        return "register";
    }

    @PostMapping("/register_add")
    @ResponseBody
    public RestResult add(@RequestBody User user) {
        String msg;
        if (user.getUserName().isEmpty() || user.getUserPwd().isEmpty()) {
            msg = "用户名或密码不能为空";
            return resultGenerator.getFailResult(msg);
        } else {
            userService.createEntity(user);
            return resultGenerator.getSuccessResult(user);
        }
    }
}
