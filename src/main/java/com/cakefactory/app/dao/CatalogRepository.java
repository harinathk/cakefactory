package com.cakefactory.app.dao;

import com.cakefactory.app.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Item, String> {

}
