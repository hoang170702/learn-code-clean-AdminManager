package com.demo.invokingmethod.model;

import com.demo.invokingmethod.utils.ConfigStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product
{
    private Long id;

    private String category;

    private String name;

    private String price;

    private ConfigStatus status;
}
