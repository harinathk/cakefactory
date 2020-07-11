package com.cakefactory.app.service;

import com.cakefactory.app.dao.CatalogRepository;
import com.cakefactory.app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    CatalogRepository catalogRepository;

    @Override
    public List<Item> findAll() {
        return catalogRepository.findAll();
    }
}
