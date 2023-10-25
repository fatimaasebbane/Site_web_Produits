package com.example.site_web_produits.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Valeur> valeurs;

}
