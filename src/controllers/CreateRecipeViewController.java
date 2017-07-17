package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Ingredient;
import model.Recipe;
import model.RecipeStep;
import model.repository.IngredientRepository;
import model.repository.RecipeRepository;

/**
 * Created by mattpetters on 7/13/17.
 */
public class CreateRecipeViewController {
	
	//recipe name
	//search for ingredients
	//ingredients in recipe
	//steps

	@FXML
	TableView recipeIngredientsView;

	@FXML
	TextField ingredientNameField;
	@FXML
	TextArea stepsTextArea;

	@FXML
	TableColumn recipeIngredientColumn;

	@FXML
			TableColumn ingredientActionColumn;
	
	
	RecipeRepository recipeRepo = new RecipeRepository();
	IngredientRepository ingredientRepo = new IngredientRepository();
	
	 private AnchorPane viewport;

	@FXML
	public void initialize(){
		configureTable();
	}

	public void configureTable(){
		recipeIngredientColumn.setCellValueFactory(new PropertyValueFactory<Recipe,String>("name"));
//		ingredientActionColumn.setCellValueFactory();
	}
	 
	 public void searchIngredientsPressed(){
	        //find ingredient in db, add to recipe
		 if (ingredientNameField.getText().length() > 0){
	            ArrayList<String> delimited = new ArrayList<String>();
	            delimited.addAll(Arrays.asList(ingredientNameField.getText()));
	            ArrayList<Ingredient> foundIngredient = ingredientRepo.getByName(ingredientNameField.getText());
	            if(foundIngredient.size() == 0){
	                recipeIngredientsView.setPlaceholder(new Label("No recipes found."));
				} else {
	            updateTableWithIngredient(foundIngredient);
	        	}
	    }
	}
		 
    private void updateTableWithIngredient(ArrayList<Ingredient> foundIngredient) {
        recipeIngredientsView.getItems().setAll(foundIngredient);
    }
   
    
    public void parseSteps() {
    		ArrayList<String> recipeSteps = new ArrayList<String>();
//    		recipeSteps.addAll(Arrays.asList(steps.getText().split("\\s*,\\s*")));
            	
	}
	

	public void cancelPressed() {
		
		//if cancel button pressed, user taken back to ListRecipesView screen
		 
		System.out.println("Cancel button pressed");
	     Parent recipeView = null;
	     try {
	         recipeView = FXMLLoader.load(getClass().getResource("../views/ListRecipesView.fxml"));
	         viewport.getChildren().setAll(recipeView);
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	
	public void savePressed() {
		
		//if save button pressed, recipe name, ingredients and steps saved to db, and user taken back to ListRecipesView screen
	 
		//need to write ingredients and steps to db here
		
	 	System.out.println("Save button pressed");
	    Parent recipeView = null;
	    try {
	        recipeView = FXMLLoader.load(getClass().getResource("../views/ListRecipesView.fxml"));
	        viewport.getChildren().setAll(recipeView);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
		 
	
		      
		    
	
	}
