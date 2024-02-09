package be.tftic.spring.demo.bll.impl;


import be.tftic.spring.demo.api.model.dto.MenuDTO;
import be.tftic.spring.demo.bll.services.MenuService;
import be.tftic.spring.demo.dal.MenuRepository;
import be.tftic.spring.demo.domain.entities.Menu;
import be.tftic.spring.demo.domain.enums.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public MenuDTO getMenuById(int id) {
        Menu menu = menuRepository.findById(id).orElse(null);
        return mapMenuToDTO(menu);
    }

    @Override
    public List<MenuDTO> getMenuByCategory(Categorie category) {
        List<Menu> menus = menuRepository.findByCatégorie(category);
        return menus.stream().map(this::mapMenuToDTO).collect(Collectors.toList());
    }

    @Override
    public MenuDTO createMenu(MenuDTO menuDTO) {
        return null;
    }

    @Override
    public MenuDTO updateMenu(int id, MenuDTO menuDTO) {
        return null;
    }

    @Override
    public boolean deleteMenu(int id) {
        return false;
    }

    private MenuDTO mapMenuToDTO(Menu menu) {
        if ( menu == null ) {
            return null;
        }
        return new MenuDTO(menu.getIdMenu(), menu.getNomMenu(), menu.getPrix(), menu.getCatégorie());
    }
}
