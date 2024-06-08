package com.coderscampus.Assignment9.web;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/recipes")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return fileService.getAllRecipes();
    }


@GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return fileService.getGlutenFreeRecipes();
    }
    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return fileService.getVegetarianRecipes();
    }


@GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return fileService.getVeganRecipes();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return fileService.getVeganAndGlutenFreeRecipes();
    }
}





