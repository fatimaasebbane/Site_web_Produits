package com.example.site_web_produits.DAO;

import com.example.site_web_produits.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
