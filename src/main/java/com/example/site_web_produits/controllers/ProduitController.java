package com.example.site_web_produits.controllers;


import com.example.site_web_produits.Services.ProduitService;
import com.example.site_web_produits.dto.GetCategoryDto;
import com.example.site_web_produits.dto.ListProductDto;
import com.example.site_web_produits.dto.ProduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Products")
public class ProduitController {

    @Autowired
    ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("ListByCategory")
    public List<ListProductDto> getProductsByCategory(@RequestBody GetCategoryDto categoryDto){
        return produitService.getByCategory(categoryDto);
    }
}
