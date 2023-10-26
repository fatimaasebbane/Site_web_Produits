package com.example.site_web_produits.Services;

import com.example.site_web_produits.DAO.ProduitRepository;
import com.example.site_web_produits.DAO.ValeurRepository;
import com.example.site_web_produits.dto.CreateCategoryDto;
import com.example.site_web_produits.dto.CreateProduitDto;
import com.example.site_web_produits.models.Produit;
import com.example.site_web_produits.models.Valeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    ValeurRepository valeurRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public String save(CreateProduitDto createProduitDto){

       Produit produit=createProduitDto.getProduit();
       produitRepository.save(produit);
       Integer id_produit=produit.getId();
        List<Valeur> valeurs=createProduitDto.getValeurs();
        for (Valeur valeur:valeurs){
            valeur.setProduit(produit);
            valeurRepository.save(valeur);
        }

        return "le produit est bien ajoutée";
    }


}
