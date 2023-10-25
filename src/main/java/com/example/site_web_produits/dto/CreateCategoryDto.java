package com.example.site_web_produits.dto;

import com.example.site_web_produits.models.Category;
import com.example.site_web_produits.models.Champ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDto {

    private Category category;
    private List<Champ> champList;
}
