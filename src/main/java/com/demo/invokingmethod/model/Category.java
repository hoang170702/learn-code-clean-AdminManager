package com.demo.invokingmethod.model;

import com.demo.invokingmethod.utils.ConfigStatus;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private Long id;
    private String name;
    private ConfigStatus status;
}
