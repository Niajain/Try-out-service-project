package com.example.tryout.dto.response;

import com.example.tryout.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    int quantityAvailable;
    double price;
    ProductStatus productStatus;

}
