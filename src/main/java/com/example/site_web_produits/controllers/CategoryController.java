package com.example.site_web_produits.Controllers;

import com.example.site_web_produits.Services.CategoryService;
import com.example.site_web_produits.Services.ChampService;
import com.example.site_web_produits.dto.CreateCategoryDto;
import com.example.site_web_produits.dto.GetCategoryDto;
import com.example.site_web_produits.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    private  ChampService champService;
    @Autowired
    private CategoryService categoryService;

    public CategoryController(ChampService champService, CategoryService categoryService) {
        this.champService = champService;
        this.categoryService = categoryService;
    }

    @PostMapping("create")
    public Boolean create(@RequestBody CreateCategoryDto categoryDto) {

        Category cat = categoryService.save(categoryDto.getCategory());
        if (cat != null){
            champService.save(categoryDto.getChampList(),cat);
            return true;
        }
        return  false;
    }

    @GetMapping("all")
    public List<GetCategoryDto> getAll(){
        return  categoryService.getAll();

    }


}
