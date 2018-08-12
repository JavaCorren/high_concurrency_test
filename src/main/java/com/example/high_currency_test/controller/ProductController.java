package com.example.high_currency_test.controller;

import com.example.high_currency_test.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品controller类
 *
 * @author ZhangGR
 * @created on 2018/8/12
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    /**
     * 获取商品列表
     * @param model
     * @param userInfo
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, UserInfo userInfo) {

        model.addAttribute("user",userInfo);
        return "product";
    }
}
