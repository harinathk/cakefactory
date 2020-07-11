package com.cakefactory.app.service;

import com.cakefactory.app.model.Item;

import java.util.List;

public interface CatalogService {

    List<Item> findAll();
}
