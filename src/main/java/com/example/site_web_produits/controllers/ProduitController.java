package com.example.site_web_produits.Controllers;
import com.example.site_web_produits.Services.ProduitService;
import com.example.site_web_produits.dto.CreateProduitDto;
import com.example.site_web_produits.dto.GetCategoryDto;
import com.example.site_web_produits.dto.ListProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@CrossOrigin

public class ProduitController {

    @Autowired
    ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }
    @PostMapping("/creer")
    public String  creerProduit(@RequestBody CreateProduitDto createProduitDto) {
        return produitService.save(createProduitDto);
    }

    @PostMapping("ListByCategory")
    public List<ListProductDto> getProductsByCategory(@RequestBody GetCategoryDto categoryDto){
        return produitService.getByCategory(categoryDto);

    }

}
