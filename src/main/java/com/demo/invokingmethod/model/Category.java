package com.demo.invokingmethod.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Category {
    private Long id;
    private String name;
    private String status;
}
