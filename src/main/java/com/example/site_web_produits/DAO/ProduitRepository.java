package com.example.site_web_produits.DAO;

import com.example.site_web_produits.models.Category;
import com.example.site_web_produits.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {

    List<Produit> findByCategory(Category category);
}
