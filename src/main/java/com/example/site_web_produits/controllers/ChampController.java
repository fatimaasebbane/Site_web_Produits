package com.example.site_web_produits.Controllers;

import com.example.site_web_produits.Services.ChampService;
import com.example.site_web_produits.dto.getChampsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/champs")
@CrossOrigin
public class ChampController {
    @Autowired
    ChampService champService;

    public ChampController(ChampService champService) {
        this.champService = champService;
    }

    @GetMapping("getChamps/{nom_category}")
    public List<getChampsDTO> getAllChamps(@PathVariable String nom_category){
      return   champService.getChampsByCategory(nom_category);
    }
}
