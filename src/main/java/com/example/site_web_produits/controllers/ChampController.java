package com.example.site_web_produits.Controllers;

import com.example.site_web_produits.Services.ChampService;
import com.example.site_web_produits.dto.getChampsDTO;
import com.example.site_web_produits.models.Champ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/champs")
public class ChampController {
    @Autowired
    ChampService champService;

    public ChampController(ChampService champService) {
        this.champService = champService;
    }

    @GetMapping("getChamps/{id_category}")
    public List<getChampsDTO> getAllChamps(@PathVariable Integer id_category){
      return   champService.getChampsByCategory(id_category);
    }
}
