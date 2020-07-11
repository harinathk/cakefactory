package com.cakefactory.app.controller;

import com.cakefactory.app.model.Item;
import com.cakefactory.app.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/")
    public String index(Model model) {

        List<Item> items = new ArrayList<>();
        catalogService.findAll().forEach(items::add);
        items= items.stream().map(
                item -> new Item(item.getId(),  item.getName(), item.getPrice()))
                .collect(Collectors.toList());

        model.addAttribute("items", items);
        return "index";
    }

}
