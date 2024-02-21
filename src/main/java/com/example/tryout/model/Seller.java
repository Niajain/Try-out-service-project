package com.example.tryout.model;
import com.example.tryout.Enum.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="seller")
public class Seller {
    @Id
    int id;
    String fullName;
    String mobileNumber;
    int age;
    Gender gender;

    String city;
}
