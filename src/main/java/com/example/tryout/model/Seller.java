package com.example.tryout.model;
import com.example.tryout.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="seller")

@Builder
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String uniqueSellerNumber;

    String fullName;

    @Column(unique = true)
    String mobileNumber;
    int age;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)  //where join column is not writtent we have to add mappedBy so to link both tables in bidiretional relationship
    //@JsonManagedReference
    List<Product> products=new ArrayList<>();
}

