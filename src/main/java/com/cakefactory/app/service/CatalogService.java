package com.cakefactory.app.service;

import com.cakefactory.app.model.ItemDTO;

public interface CatalogService {

    Iterable<ItemDTO> getItems();
}
