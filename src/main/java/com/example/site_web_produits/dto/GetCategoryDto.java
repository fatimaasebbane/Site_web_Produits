package com.example.site_web_produits.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryDto {
    private Integer id;
    private String nom;
}
