package com.cakefactory.app;

import com.cakefactory.app.dao.CatalogRepository;
import com.cakefactory.app.model.Item;
import com.cakefactory.app.model.ItemDTO;
import com.cakefactory.app.service.CatalogServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;

@DataJpaTest
class JpaCatalogServiceTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    CatalogRepository catalogRepository;

    private CatalogServiceImpl catalogServiceImpl;

    @BeforeEach
    void setup() {
        this.catalogServiceImpl = new CatalogServiceImpl(this.catalogRepository);
    }

    @Test
    @DisplayName("returns data from the database")
    void returnsDataFromDatabase() {
        String expectedTitle = "Victoria Sponge";
        saveTestItem(expectedTitle, BigDecimal.valueOf(5.55));

        Iterable<ItemDTO> items = catalogServiceImpl.getItems();

        org.assertj.core.api.Assertions.assertThat(items).anyMatch(item -> expectedTitle.equals(item.getName()));
    }

    private void saveTestItem(String title, BigDecimal price) {
        Item itemEntity = new Item();
        itemEntity.setSku("test-item-1");
        itemEntity.setName(title);
        itemEntity.setPrice(price);

        testEntityManager.persistAndFlush(itemEntity);
    }

}