package com.cakefactory.app.service;

import com.cakefactory.app.dao.CatalogRepository;
import com.cakefactory.app.model.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CatalogServiceImpl implements CatalogService{


    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Iterable<ItemDTO> getItems() {
        return StreamSupport.stream(catalogRepository.findAll().spliterator(), false)
                .map(entity -> new ItemDTO(entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }
}
