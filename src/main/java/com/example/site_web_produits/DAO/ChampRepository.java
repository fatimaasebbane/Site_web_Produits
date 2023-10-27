package com.example.site_web_produits.DAO;

import com.example.site_web_produits.models.Champ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampRepository extends JpaRepository<Champ,Integer> {
    public List<Champ> getChampByCategory_Nom(String nom);
}
