package com.example.site_web_produits.DAO;

import com.example.site_web_produits.models.Produit;
import com.example.site_web_produits.models.Valeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ValeurRepository extends JpaRepository<Valeur,Integer> {


    List<Valeur> findByProduit(Produit produit);
}
