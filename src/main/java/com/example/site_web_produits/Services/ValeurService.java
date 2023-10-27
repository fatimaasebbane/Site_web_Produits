package com.example.site_web_produits.Services;



import com.example.site_web_produits.DAO.ChampRepository;
import com.example.site_web_produits.DAO.ValeurRepository;
import com.example.site_web_produits.dto.ProduitDto;
import com.example.site_web_produits.dto.ValeurChampDto;
import com.example.site_web_produits.models.Produit;
import com.example.site_web_produits.models.Valeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValeurService {

    @Autowired
    ValeurRepository valeurRepository;


    public ValeurService(ValeurRepository valeurRepository) {
        this.valeurRepository = valeurRepository;
    }

    public List<ValeurChampDto>  getPriductAttributes(Produit produit){
        List<Valeur> valeurs = valeurRepository.findByProduit(produit);
        List<ValeurChampDto> valeurChampDtos = valeurs.stream().
                map(valeur -> new ValeurChampDto(valeur.getChamp().getName(),valeur.getValue()))
                .collect(Collectors.toList());
        return valeurChampDtos;
    }



}
