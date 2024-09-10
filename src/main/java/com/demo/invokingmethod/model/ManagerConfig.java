package com.demo.invokingmethod.model;


import com.demo.invokingmethod.utils.TypeConfig;
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
    private TypeConfig type;
    private Boolean isDelete;
}
