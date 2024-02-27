package com.example.tryout.service;

import com.example.tryout.dto.request.SellerRequest;
import com.example.tryout.dto.response.SellerResponse;
import com.example.tryout.model.Seller;
import com.example.tryout.repository.SellerRepository;
import com.example.tryout.service.transformer.SellerTransformer;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerResponse addSeller(SellerRequest sellerRequest) {
        Seller seller= SellerTransformer.sellerRequestToSeller(sellerRequest);
        Seller savedSeller= sellerRepository.save(seller);
        return SellerTransformer.sellerToSellerResponse(savedSeller);
    }
}
