package com.mark45.Controller;

import com.mark45.Payload.Productdto;
import com.mark45.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Productdto> createProduct(@RequestBody Productdto productdto) {
        logger.info("Request to create product received: {}", productdto);

        Productdto createdProduct = productService.createProduct(productdto);

        logger.info("Product created successfully: {}", createdProduct);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
}

