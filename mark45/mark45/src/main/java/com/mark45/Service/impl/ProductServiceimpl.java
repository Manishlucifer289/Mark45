package com.mark45.Service.impl;

import com.mark45.Entity.Product;
import com.mark45.Payload.Productdto;
import com.mark45.Repository.ProductRepository;
import com.mark45.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Productdto createProduct(Productdto productdto) {
        String postid = UUID.randomUUID().toString();
        productdto.setId(postid);
        Product product =  maptoEntity(productdto);
        Product saved = productRepository.save(product);
        Productdto dto = maptoDto(saved);
        return dto;
    }

    Product maptoEntity(Productdto productdto){
        Product product = modelMapper.map(productdto, Product.class);
        return product;
    }
    Productdto maptoDto(Product product){
        Productdto dto = modelMapper.map(product, Productdto.class);
        return dto;
    }


}
