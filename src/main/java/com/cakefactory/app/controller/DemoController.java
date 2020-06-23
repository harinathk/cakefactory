package com.cakefactory.app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    public String showDemoPage(Model model) {

        model.addAttribute("testAttribute", "I am from the Controller");
        return "demo";
    }


}
