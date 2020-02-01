package com.holiday.controller;

import com.holiday.entity.User;
import com.holiday.service.UserService;
import com.holiday.util.RestResult;
import com.holiday.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResultGenerator resultGenerator;

    @RequestMapping("")
    public String index() {
        return "login";
    }

    @PostMapping("/loginIn")
    @ResponseBody
    public RestResult loginIn(String userName, String password,HttpServletRequest request) {
        User loginUser = userService.findByUserInfo(userName, password);
        if (loginUser == null) {
            return resultGenerator.getFailResult("用户名或密码不正确！");
        } else {
            request.getSession().setAttribute("userName", userName);
            request.getSession().setAttribute("userPwd", password);
            return resultGenerator.getSuccessResult(loginUser);
        }
    }

    @GetMapping("/success")
    public String success(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String userPwd = (String) session.getAttribute("userPwd");
        if (userService.findByUserInfo(userName, userPwd) != null) {
            return "starter";
        }
        //如果未登陆则重定向到登陆页面
        return "redirect:";
    }

}
