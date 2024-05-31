package com.coderscampus.Assignment9;

import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {

    @Autowired
   private FileService fileService;

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return fileService.getAllRecipes();
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return fileService.getGlutenFreeRecipes();
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return fileService.getVeganRecipes();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return fileService.getVeganAndGlutenFreeRecipes();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return fileService.getVegetarianRecipes();
    }

}

//@RestController
//@RequestMapping("/recipes")
//public class FileController {
//
//    @Autowired
//    private FileService fileService;
//
//    @GetMapping("/gluten-free")
//    public List<Recipe> getGlutenFreeRecipes() {
//        return fileService.getGlutenFreeRecipes();
//    }
//
//    @GetMapping("/vegan")
//    public List<Recipe> getVeganRecipes() {
//        return fileService.getVeganRecipes();
//    }
//
//    @GetMapping("/vegan-and-gluten-free")
//    public List<Recipe> getVeganAndGlutenFreeRecipes() {
//        return fileService.getVeganAndGlutenFreeRecipes();
//    }
//
//    @GetMapping("/vegetarian")
//    public List<Recipe> getVegetarianRecipes() {
//        return fileService.getVegetarianRecipes();
//    }
//
//    @GetMapping("/all-recipes")
//    public List<Recipe> getAllRecipes() {
//        return fileService.getAllRecipes();
//    }
//}
//    @Autowired
//    private FileService fileService;

            //    @GetMapping("/gluten-free")
//
//    @GetMapping("/vegan")
//
//    @GetMapping("/vegan-and-gluten-free")
//
//    @GetMapping("/vegetarian")
//
//    @GetMapping("/all-recipes")
//    public List<String> readFile() throws IOException {
//
//        return Files.readAllLines(Paths.get("recipes.txt"));
//
//    }



