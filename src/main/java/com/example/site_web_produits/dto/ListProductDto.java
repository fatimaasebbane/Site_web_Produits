package com.example.site_web_produits.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListProductDto {
    private Integer id;
    private String nom;
    private List<ValeurChampDto> valeurChampList;

}
