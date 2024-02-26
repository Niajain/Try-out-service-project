package com.example.tryout.dto.request;

import com.example.tryout.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Getter
@Setter
public class CustomerRequest {

    String name;

    String emailId;

    int age;


    Gender gender;


    String city;

}
