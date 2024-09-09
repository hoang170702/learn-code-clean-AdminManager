package com.demo.invokingmethod.model;


import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String fullName;

    private String email;

    private String status;
}
