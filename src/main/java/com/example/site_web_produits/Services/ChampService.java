package com.example.site_web_produits.Services;

import com.example.site_web_produits.DAO.ChampRepository;
import com.example.site_web_produits.dto.getChampsDTO;
import com.example.site_web_produits.models.Champ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChampService {
    
    @Autowired
    ChampRepository champRepository;
    
    public  ChampService (ChampRepository champRepository){
        this.champRepository = champRepository;
    }
    
    public void save(List<Champ> champList){

        for (Champ champ: champList) {
            champRepository.save(champ);
        }
    }
    public List<getChampsDTO> getChampsByCategory(Integer id_category)
    {
        List<Champ> champList= champRepository.getChampByCategory_Id(id_category);
        List<getChampsDTO> champsDTOS=champList.stream().map(champ -> new getChampsDTO(champ.getName(),champ.getType())).collect(Collectors.toList());
        return champsDTOS;
    }
}
