package com.example.site_web_produits.controllers;
import com.example.site_web_produits.DAO.ProduitRepository;
import com.example.site_web_produits.Services.ProduitService;
import com.example.site_web_produits.dto.CreateProduitDto;
import com.example.site_web_produits.dto.GetCategoryDto;
import com.example.site_web_produits.dto.ListProductDto;
import com.example.site_web_produits.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/produits")
@CrossOrigin

public class ProduitController {
    private static final Logger LOGGER = Logger.getLogger(ProduitController.class.getName());


    @Autowired
    ProduitService produitService;
    @Autowired
    ProduitRepository produitRepository;

    public ProduitController(ProduitService produitService , ProduitRepository produitRepository) {
        this.produitService = produitService;
        this.produitRepository = produitRepository;
    }
    @PostMapping("/creer")
    public Integer  creerProduit(@RequestBody CreateProduitDto createProduitDto) {
        return produitService.save(createProduitDto);
    }


    @PostMapping(value = "/uploadImage", consumes = { "multipart/form-data" })
    public String uploadProductImage(@RequestParam("file") MultipartFile file, @RequestParam("productId") Integer productId) {
        Produit produit = produitRepository.findById(productId).orElse(null);
        if (produit != null) {
            try {
                if (file != null && !file.isEmpty()) {
                    byte[] imageBytes = file.getBytes();
                    produit.setPictrure(imageBytes);
                    produitRepository.save(produit);
                    return "Product added successfully";
                }
                return "No image provided for update";
            } catch (IOException e) {
                e.printStackTrace();
                return "Error uploading the image.";
            }
        } else {
            return "Product not found";
        }
    }
    @GetMapping("/image/{productId}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Integer productId) {

        Produit produit = produitRepository.findById(productId).orElse(null);
        byte[] image = produit.getPictrure();
        if (image != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping("ListByCategory")
    public List<ListProductDto> getProductsByCategory(@RequestBody GetCategoryDto categoryDto){
        return produitService.getByCategory(categoryDto);

    }

}
