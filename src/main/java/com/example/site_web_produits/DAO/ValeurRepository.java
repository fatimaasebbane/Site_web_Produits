package com.example.site_web_produits.DAO;

import com.example.site_web_produits.models.Valeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValeurRepository extends JpaRepository<Valeur,Integer> {
}
