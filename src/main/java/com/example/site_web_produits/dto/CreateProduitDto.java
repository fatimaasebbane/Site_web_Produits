package com.example.site_web_produits.dto;


import com.example.site_web_produits.models.Produit;
import com.example.site_web_produits.models.Valeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProduitDto {
    private Produit produit;
    private List<Valeur> valeurs;
}
