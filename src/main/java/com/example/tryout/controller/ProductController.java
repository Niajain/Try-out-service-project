package com.example.tryout.controller;

import com.example.tryout.dto.request.ProductRequest;
import com.example.tryout.model.Product;
import com.example.tryout.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestParam("s_id") String sellerUniqueNumber,
            @RequestBody ProductRequest productRequest)
    {
        return productService.addProduct(sellerUniqueNumber,productRequest);
    }
}
