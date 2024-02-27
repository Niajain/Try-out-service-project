package com.example.tryout.service.transformer;

import com.example.tryout.Enum.ProductStatus;
import com.example.tryout.dto.request.ProductRequest;
import com.example.tryout.model.Product;

public class ProductTransformer {

    public static Product productRequestToProduct(ProductRequest productRequest)
    {
        return Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantityAvailable(productRequest.getQuantityAvailable())
                .description(productRequest.getDescription())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }
}
