package com.example.tryout.service;

import com.example.tryout.model.Coupon;
import com.example.tryout.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }


    public void addCoupon(String couponCode, double percentageDiscount) {
        Coupon coupon=Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(percentageDiscount)
                .build();
        couponRepository.save(coupon);


    }
}
