package com.example.tryout.repository;

import com.example.tryout.Enum.Gender;
import com.example.tryout.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByEmailId(String email);


    List<Customer> findByAge(int age);

    List<Customer> findByGenderAndAge(Gender gender, int age);

    @Query("select count(c) from Customer c where c.age > :a")
    int getCountOfAgeGreaterThan(@Param("a") int age);

//    @Query("select count(c) from Customer c where c.gender = :gender")
//    int getCountOfGender(@Param("gender") Gender gender);

    @Query(value = "select count(*) from customer where gender = :gender",nativeQuery = true)
    int getCountOfGender(@Param("gender") String gender);
}
