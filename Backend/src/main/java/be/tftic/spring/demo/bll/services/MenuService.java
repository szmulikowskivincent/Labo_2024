package be.tftic.spring.demo.bll.services;


import be.tftic.spring.demo.api.model.dto.MenuDTO;
import be.tftic.spring.demo.domain.enums.Categorie;

import java.util.List;

public interface MenuService {

    MenuDTO getMenuById(int id);

    List<MenuDTO> getMenuByCategory(Categorie category);

    MenuDTO createMenu(MenuDTO menuDTO);

    MenuDTO updateMenu(int id, MenuDTO menuDTO);

    boolean deleteMenu(int id);
}

