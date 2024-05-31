package com.coderscampus.Assignment9;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@Component
public class RecipeParser {
    public List<Recipe> parseRecipes(InputStream fileContent) {
        List<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim())) {

            for (CSVRecord csvRecord : csvParser) {
                Recipe recipe = new Recipe();
                recipe.setCookingMinutes(parseInteger(csvRecord.get("Cooking Minutes")));
                recipe.setDairyFree(parseBoolean(csvRecord.get("Dairy Free")));
                recipe.setGlutenFree(parseBoolean(csvRecord.get("Gluten Free")));
                recipe.setInstructions(csvRecord.get("Instructions"));
                recipe.setPreparationMinutes(parseDouble(csvRecord.get("Preparation Minutes")));
                recipe.setPricePerServing(parseDouble(csvRecord.get("Price Per Serving")));
                recipe.setReadyInMinutes(parseInteger(csvRecord.get("Ready In Minutes")));
                recipe.setServings(parseInteger(csvRecord.get("Servings")));
                recipe.setSpoonacularScore(parseDouble(csvRecord.get("Spoonacular Score")));
                recipe.setTitle(csvRecord.get("Title"));
                recipe.setVegan(parseBoolean(csvRecord.get("Vegan")));
                recipe.setVegetarian(parseBoolean(csvRecord.get("Vegetarian")));

                recipes.add(recipe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipes;
    }
    private Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("Invalid integer value: " + value);
            return 0;
        }
    }

//    private Integer parseInteger(String value) {
//        try {
//            return Integer.parseInt(value);
//        } catch (NumberFormatException e) {
//            System.err.println("Invalid integer value: " + value);
//            return 0; // Default value
//        }
//    }
    private Double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            System.err.println("Invalid double value: " + value);
            return 0.0;
        }
    }
//    private Double parseDouble(String value) {
//        try {
//            return Double.parseDouble(value);
//        } catch (NumberFormatException e) {
//            System.err.println("Invalid double value: " + value);
//            return 0.0; // Default value
//        }
//    }
    private Boolean parseBoolean(String value) {
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(value);
        } else if(value.equalsIgnoreCase("1")) {
            return true;
        } else if(value.equalsIgnoreCase("0")) {
            return false;
        } else {
            System.err.println("Invalid boolean value: " + value);
            return false;
        }
    }

//    private Boolean parseBoolean(String value) {
//        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
//            return Boolean.parseBoolean(value);
//        } else {
//            System.err.println("Invalid boolean value: " + value);
//            return false; // Default value
//        }
//    }
}

