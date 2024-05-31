package com.coderscampus.Assignment9;

import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    private List<Recipe> recipes;

    @Autowired
    private RecipeParser recipeParser;
//@Autowired
//    public FileService(String file) {
//    }

    @PostConstruct
    public void init() {
        try (InputStream fileContent = getClass().getResourceAsStream("/recipes.txt")) {
            if (fileContent != null) {
                this.recipes = recipeParser.parseRecipes(fileContent);
            } else {
                System.err.println("Recipe file not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return recipes.stream()
                .filter(Recipe::getGlutenFree)
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganRecipes() {
        return recipes.stream()
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipes.stream()
                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    public List<Recipe> getVegetarianRecipes() {
        return recipes.stream()
                .filter(Recipe::getVegetarian)
                .collect(Collectors.toList());
    }
}
//@Service
//@Scope (ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//
//public class FileService {
//    private List<Recipe> recipes;
//
//    @Autowired
//    private RecipeParser recipeParser;
//
//    @Autowired
//    private ResourceLoader resourceLoader;
//
////    public FileService(String file) {
////
////    }
//
//    @PostConstruct
//    public void init() {
//        try {
//            Resource resource = resourceLoader.getResource("classpath:recipes.txt");
//            InputStream in = resource.getInputStream();
//            this.recipes = recipeParser.parseRecipes(in);
//        } catch (Exception e) {
//            System.err.println("Error occurred while reading the file: " + e.getMessage());
//        }
//    }
//
////    public void init() {
////        try {
////            this.recipes = recipeParser.parseRecipes("recipes.txt"); // Adjust the path to your file
////        } catch (Exception e) {
////            // log the exception stack trace
////            e.printStackTrace();
////        }
////    }
//
//    public List<Recipe> getAllRecipes() {
//        return recipes;
//    }
//
//    public List<Recipe> getGlutenFreeRecipes() {
//        return recipes.stream()
//                .filter(Recipe::getGlutenFree)
//                .toList();
//    }
//
//    public List<Recipe> getVeganRecipes() {
//        return recipes.stream()
//                .filter(Recipe::getVegan)
//                .toList();
//    }
//
//    public List<Recipe> getVeganAndGlutenFreeRecipes() {
//        return recipes.stream()
//                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
//                .toList();
//    }
//
//    public List<Recipe> getVegetarianRecipes() {
//        return recipes.stream()
//                .filter(Recipe::getVegetarian)
//                .toList();
//    }
//}
//
//
//


    //    public FileService(String file) {
//    }

//    private String fileName;
//
//    public FileService(String fileName) throws IOException {
//        this.fileName = fileName;
//
//    }
//
//
//    public List<String> readFile() throws IOException {
//
//        return Files.readAllLines(Paths.get(fileName));
//    }

//    public void parseRecipeFile() throws IOException {
//        FileReader in = new FileReader(fileName);
//        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
//
//        for (CSVRecord record : records) {
//            String columnOne = record.get(0);
//            String columnTwo = record.get(1);
//            String columnThree = record.get(2);
//            String columnFour = record.get(3);
//            String columnFive = record.get(4);
//            String columnSix = record.get(5);
//            String columnSeven = record.get(6);
//            String columnEight = record.get(7);
//            String columnNine = record.get(8);
//            String columnTen = record.get(9);
//            String columnEleven = record.get(10);
//            String columnTwelve = record.get(11);
//            String columnThirteen = record.get(12);
//        }
        // System.out.println(records);
        //return records.toString();







