package com.coderscampus.Assignment9.web;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


//    @GetMapping("/all-recipes")
//    public List<Recipe> getAllRecipes() {
//
//        return fileService.getAllRecipes();
//    }
//
//    @GetMapping("/gluten-free")
//    public List<Recipe> getGlutenFreeRecipes() {
//        return fileService.getGlutenFreeRecipes().stream().filter(recipe -> Boolean.TRUE.equals(recipe.getGlutenFree()))
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/vegan")
//    public List<Recipe> getVeganRecipes() {
//        return fileService.getAllRecipes().stream()
//                .filter(recipe -> Boolean.TRUE.equals(recipe.getVegan()))
//                .collect(Collectors.toList());
//    }

//    public List<Recipe> getVeganRecipes() {
//        return fileService.getVeganRecipes().stream().filter(recipe -> Boolean.TRUE.equals(getVeganRecipes())).toList();
//    }

//    @GetMapping("/vegan-and-gluten-free")
//    public List<Recipe> getVeganAndGlutenFreeRecipes() {
//        return fileService.getVeganAndGlutenFreeRecipes();
//    }


//    @GetMapping("/vegetarian")
//    public boolean getVegetarianRecipes() {
//        return fileService.getVegetarianRecipes()
//                .stream().filter(recipe-> getVegetarianRecipes().equals(Boolean.TRUE))
//    }
//    }

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



