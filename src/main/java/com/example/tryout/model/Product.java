package com.example.tryout.model;

import com.example.tryout.Enum.ProductStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="product")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    double price;

    int quantityAvailable;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    String description;

    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonIgnore
    //@JsonBackReference
    Seller seller;

}
