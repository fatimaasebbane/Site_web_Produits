package com.example.site_web_produits.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Valeur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    private String value;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Champ champ;
}
