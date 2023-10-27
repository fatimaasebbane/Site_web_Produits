package com.example.site_web_produits.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class getChampsDTO {
    private Integer id;
    private String name;
    private String type;
}
