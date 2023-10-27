package com.example.site_web_produits.Controllers;

import com.example.site_web_produits.Services.ProduitService;
import com.example.site_web_produits.dto.CreateProduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produits")
@CrossOrigin
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @PostMapping("/creer")
    public String  creerProduit(@RequestBody CreateProduitDto createProduitDto) {
        return  produitService.save(createProduitDto);
    }
}
