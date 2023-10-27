package com.example.site_web_produits.Services;


import com.example.site_web_produits.DAO.ValeurRepository;
import com.example.site_web_produits.dto.CreateCategoryDto;
import com.example.site_web_produits.dto.CreateProduitDto;
import com.example.site_web_produits.models.Valeur;
import com.example.site_web_produits.DAO.CategoryRepository;
import com.example.site_web_produits.DAO.ProduitRepository;
import com.example.site_web_produits.dto.GetCategoryDto;
import com.example.site_web_produits.dto.ListProductDto;
import com.example.site_web_produits.dto.ProduitDto;
import com.example.site_web_produits.dto.ValeurChampDto;
import com.example.site_web_produits.models.Category;
import com.example.site_web_produits.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProduitService {


    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    ValeurRepository valeurRepository;
    @Autowired
      CategoryRepository categoryRepository;

    public ProduitService(CategoryRepository categoryRepository, ProduitRepository produitRepository,ValeurService valeurService) {
            this.categoryRepository = categoryRepository;
            this.produitRepository = produitRepository;
            this.valeurService = valeurService;

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



      

      public List<ListProductDto> getByCategory(GetCategoryDto categoryDto) {
            Category category = categoryRepository.findByNom(categoryDto.getNom());
            if (category != null) {
                  List<Produit> produits = produitRepository.findByCategory(category);
                  List<ListProductDto> produitDtos = produits.stream()
                          .map(produit -> {
                                List<ValeurChampDto> valeurChampDtos = valeurService.getPriductAttributes(produit);
                                return new ListProductDto(produit.getNom(), valeurChampDtos);
                          })
                          .collect(Collectors.toList());
                  return produitDtos;
            }
            return null;
      }


}
