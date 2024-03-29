package com.example.tryout.model;
import com.example.tryout.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;

    @Column(name="name")
    String name;

    @Column(unique = true,nullable = false)
    @Email
    String emailId;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Size(min = 2, max = 20)
    String city;

    @CreationTimestamp
    Date created;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="identity_id")
    Identity identity;
}
