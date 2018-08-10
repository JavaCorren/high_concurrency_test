package com.example.high_currency_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ZhangGR
 * @Created on 2018/8/10
 * @Description
 */
@Controller
public class DemoController {

    @ModelAttribute
    public void setMyModel(@RequestParam(required = false, defaultValue = "Corren") String name, Model model) {
        model.addAttribute("name", name);
    }

    @RequestMapping("/templates/hello")
    public String hello() {

        return "hello";
    }
}
