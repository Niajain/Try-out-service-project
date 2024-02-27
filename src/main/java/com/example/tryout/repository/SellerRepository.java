package com.example.tryout.repository;


import com.example.tryout.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SellerRepository extends JpaRepository<Seller,Integer> {
}
