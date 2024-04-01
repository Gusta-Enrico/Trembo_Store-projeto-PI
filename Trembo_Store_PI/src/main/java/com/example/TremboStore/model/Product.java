package com.example.TremboStore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double preco;
    @Column
    private int estoque;
    @Column
    private String nameFileImage;

}

