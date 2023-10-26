package com.example.site_web_produits.Services;

import com.example.site_web_produits.DAO.ValeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValeurService {

    @Autowired
    ValeurRepository valeurRepository;


}
