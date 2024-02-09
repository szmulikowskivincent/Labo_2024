package be.tftic.spring.demo.api.controllers;

import be.tftic.spring.demo.api.model.dto.MenuDTO;
import be.tftic.spring.demo.bll.services.MenuService;
import be.tftic.spring.demo.domain.enums.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuDTO> getMenuById(@PathVariable int id) {
        MenuDTO menuDTO = menuService.getMenuById(id);
        if ( menuDTO != null ) {
            return new ResponseEntity<>(menuDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<MenuDTO>> getMenuByCategory(@RequestParam("category") Categorie category) {
        List<MenuDTO> menuDTOs = menuService.getMenuByCategory(category);
        if ( !menuDTOs.isEmpty() ) {
            return new ResponseEntity<>(menuDTOs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuDTO menuDTO) {
        MenuDTO createdMenuDTO = menuService.createMenu(menuDTO);
        return new ResponseEntity<>(createdMenuDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuDTO> updateMenu(@PathVariable int id, @RequestBody MenuDTO menuDTO) {
        MenuDTO updatedMenuDTO = menuService.updateMenu(id, menuDTO);
        if ( updatedMenuDTO != null ) {
            return new ResponseEntity<>(updatedMenuDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable int id) {
        boolean deleted = menuService.deleteMenu(id);
        if ( deleted ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}








