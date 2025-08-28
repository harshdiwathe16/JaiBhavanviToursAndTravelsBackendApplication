package com.fiveDSolutions.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Roles extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long roleId;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    

}
