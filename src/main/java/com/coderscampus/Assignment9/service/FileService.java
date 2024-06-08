package com.coderscampus.Assignment9.service;

import com.coderscampus.Assignment9.domain.Recipe;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.csv.CSVFormat.Builder.create;

@Service
public class FileService {
    private List<Recipe> recipes = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {
        loadRecipes();
    }

    public List<Recipe> loadRecipes() throws IOException {
        try (Reader in = new FileReader("recipes.txt")) {
            CSVFormat csvFormat = CSVFormat.Builder
                    .create(CSVFormat.DEFAULT)
                   // .setDelimiter(',')
                    .setQuote('\"')
                    .setIgnoreSurroundingSpaces(true)
                    .setIgnoreEmptyLines(true)
                    .setEscape('\\')
                    .setTrim(true)
                    .setHeader()

                    //.setSkipHeaderRecord(true)
                    .build();
            try (CSVParser csvParser = new CSVParser(in, csvFormat)) {
                for (CSVRecord record : csvParser) {
                    Recipe recipe = new Recipe();

                    try {
                        recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
                    } catch (NumberFormatException e) {

                    }
                    try {
                        recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
                    } catch (IllegalArgumentException e) {

                    }
                    try {
                        recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
                    } catch (IllegalArgumentException e) {

                    }
                    recipe.setInstructions(record.get("Instructions"));
                    try {
                        recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
                    } catch (NumberFormatException e) {

                    }
                    try {
                        recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
                    } catch (NumberFormatException e) {

                    }
                    try {
                        recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
                    } catch (NumberFormatException e) {

                    }
                    try {
                        recipe.setServings(Integer.parseInt(record.get("Servings")));
                    } catch (NumberFormatException e) {

                    }
                    try {
                        recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
                    } catch (NumberFormatException e) {

                    }
                    recipe.setTitle(record.get("Title"));
                    try {
                        recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
                    } catch (IllegalArgumentException e) {

                    }
                    try {
                        recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));
                    } catch (IllegalArgumentException e) {
                         e.printStackTrace();
                    }

                    recipes.add(recipe);
                }
            } catch (IOException e) {
                 e.printStackTrace();
            }
            return recipes;
        }
    }

        public List<Recipe> getAllRecipes () {
            return recipes;
        }


        public List<Recipe> getGlutenFreeRecipes () {
            return recipes.stream().filter(Recipe::getGlutenFree)
                    .collect(Collectors.toList());
        }
    public List<Recipe> getVeganRecipes() {
        List<Recipe> result = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getVegan()) {
                result.add(recipe);
            }else ;
        }
        return result;
    }
//        public List<Recipe> getVeganRecipes () {
//            return recipes.stream().filter(Recipe::getVegan).collect(Collectors.toList());
//        }

        public List<Recipe> getVeganAndGlutenFreeRecipes () {
            return recipes.stream().filter(r -> r.getVegan() && r.getGlutenFree()).collect(Collectors.toList());
        }

        public List<Recipe> getVegetarianRecipes () {
            return recipes.stream().filter(Recipe::getVegetarian).collect(Collectors.toList());
        }
    }


//    public List<Recipe> getGlutenFreeRecipes() {
//        return recipes.stream().filter(recipe -> recipe.getGlutenFree()).collect(Collectors.toList());
//    }
//    public List<Recipe> getVeganRecipes() {
//        return recipes.stream().filter(Recipe::isVegan).collect(Collectors.toList());
//    }
//
//    public List<Recipe> getVeganAndGlutenFreeRecipes() {
//        return recipes.stream().filter(r -> r.isVegan() && r.isGlutenFree()).collect(Collectors.toList());
//    }
//
//    public List<Recipe> getVegetarianRecipes() {
//        return recipes.stream().filter(Recipe::isVegetarian).collect(Collectors.toList());
//    }


//


//}
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







