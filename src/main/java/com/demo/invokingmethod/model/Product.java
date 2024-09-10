package com.demo.invokingmethod.model;

import com.demo.invokingmethod.utils.ConfigStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    private Long id;

    private String category;

    private String name;

    private String price;

    private ConfigStatus status;
}
