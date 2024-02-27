package com.example.tryout.service;

import com.example.tryout.dto.request.ProductRequest;
import com.example.tryout.exception.SellerNotFoundException;
import com.example.tryout.model.Product;
import com.example.tryout.model.Seller;
import com.example.tryout.repository.SellerRepository;
import com.example.tryout.service.transformer.ProductTransformer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final SellerRepository sellerRepository;

    public ProductService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Product addProduct(String sellerUniqueNumber, ProductRequest productRequest) {

        Optional<Seller> optionalSeller=sellerRepository.findByUniqueSellerNumber(sellerUniqueNumber);
        if(optionalSeller.isEmpty())
        {
            throw new SellerNotFoundException("Invalid Seller NUmber");

        }
        Seller seller=optionalSeller.get();

        Product product= ProductTransformer.productRequestToProduct(productRequest);

        product.setSeller(seller);

        seller.getProducts().add(product);

        Seller savedSeller=sellerRepository.save(seller);

        return savedSeller.getProducts().get(seller.getProducts().size()-1);


    }
}
