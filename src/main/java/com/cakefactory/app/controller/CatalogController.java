package com.cakefactory.app.controller;

import com.cakefactory.app.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@Slf4j
public class CatalogController {


   private final CatalogService catalogService;

    CatalogController(CatalogService catalogService){
        this.catalogService = catalogService;
    }


    @GetMapping("/")
    public ModelAndView index(Model model) {

        return new ModelAndView("catalog", Map.of("items", this.catalogService.getItems()));
    }

}
