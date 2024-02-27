package com.example.tryout.controller;

import com.example.tryout.dto.request.SellerRequest;
import com.example.tryout.dto.response.SellerResponse;
import com.example.tryout.service.SellerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }


    @PostMapping
    public SellerResponse addSeller(@RequestBody SellerRequest sellerRequest)
    {
        return sellerService.addSeller(sellerRequest);
    }
}
