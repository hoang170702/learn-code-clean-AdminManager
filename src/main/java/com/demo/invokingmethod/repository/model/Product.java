package com.demo.invokingmethod.repository.model;

import com.demo.invokingmethod.utils.ConfigStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private String name;

    private String price;

    @Enumerated(EnumType.STRING)
    private ConfigStatus status;
}
