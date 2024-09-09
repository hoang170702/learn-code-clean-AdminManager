package com.demo.invokingmethod.model;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerConfig {
    private Category category;
    private Product product;
    private User user;
}
