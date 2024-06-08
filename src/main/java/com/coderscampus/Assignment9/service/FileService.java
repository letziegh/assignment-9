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

        public List<Recipe> getVeganRecipes () {
            return recipes.stream().filter(Recipe::getVegan).collect(Collectors.toList());
        }

        public List<Recipe> getVeganAndGlutenFreeRecipes () {
            return recipes.stream().filter(r -> r.getVegan() && r.getGlutenFree()).collect(Collectors.toList());
        }

        public List<Recipe> getVegetarianRecipes () {
            return recipes.stream().filter(Recipe::getVegetarian).collect(Collectors.toList());
        }
    }









