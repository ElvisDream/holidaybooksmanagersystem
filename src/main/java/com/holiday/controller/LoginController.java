package com.holiday.controller;

import com.holiday.entity.User;
import com.holiday.service.UserService;
import com.holiday.util.RestResult;
import com.holiday.util.ResultCode;
import com.holiday.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResultGenerator resultGenerator;

    @RequestMapping("/login")
    public String index(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

    @PostMapping("/loginIn")
    @ResponseBody
    public RestResult loginIn(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User loginUser = userService.findByUserInfo(userName, password);
        if (loginUser == null) {
            return resultGenerator.getFailResult("用户名未找到或密码不正确！");
        } else {
            return resultGenerator.getSuccessResult(loginUser);
        }
    }

}
