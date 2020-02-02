package com.holiday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/book")
    public String bookView() {
        return "book";
    }

    @RequestMapping("/user")
    public String userView() {
        return "user";
    }

    @RequestMapping("/system")
    public String systemView() {
        return "system";
    }
}
