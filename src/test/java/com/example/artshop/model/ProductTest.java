package com.example.artshop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProduct() {
        Product product = new Product();
        product.setTitle("Test Title");
        product.setImageURL("www.test.com");
        assertEquals("Test Title", product.getTitle());
        assertEquals("www.test.com", product.getImageURL());
    }
}







