package com.example.tryout.service.transformer;

import com.example.tryout.dto.request.SellerRequest;
import com.example.tryout.dto.response.SellerResponse;
import com.example.tryout.model.Seller;

import java.util.UUID;

public class SellerTransformer {

    public static Seller sellerRequestToSeller(SellerRequest sellerRequest)
    {
        return Seller.builder()
                .uniqueSellerNumber(String.valueOf(UUID.randomUUID()))
                .fullName(sellerRequest.getFullName())
                .mobileNumber(sellerRequest.getMobileNumber())
                .age(sellerRequest.getAge())
                .build();
    }

    public static SellerResponse sellerToSellerResponse(Seller seller)
    {
        return SellerResponse.builder()
                .uniqueSellerNumber(seller.getUniqueSellerNumber())
                .fullName(seller.getFullName())
                .build();
    }
}
