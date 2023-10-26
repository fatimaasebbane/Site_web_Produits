package com.example.site_web_produits.Services;

import com.example.site_web_produits.DAO.CategoryRepository;
import com.example.site_web_produits.dto.GetCategoryDto;
import com.example.site_web_produits.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean save(Category category){
        Category cat = categoryRepository.findByNom(category.getNom());
        if (cat != null){
            return true;
        }
        categoryRepository.save(category);
        return false;

    }

    public List<GetCategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetCategoryDto> categoryNames = categories.stream()
                .map(category -> new GetCategoryDto(category.getNom()))
                .collect(Collectors.toList());
        return categoryNames;
    }
}
