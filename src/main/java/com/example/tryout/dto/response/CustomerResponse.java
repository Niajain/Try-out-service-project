package com.example.tryout.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Getter
@Setter

@Builder
public class CustomerResponse {

    String name;

    String emailId;

    Date created;
}
