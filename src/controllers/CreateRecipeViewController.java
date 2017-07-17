package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Ingredient;
import model.Recipe;
import model.RecipeStep;
import model.repository.IngredientRepository;

/**
 * Created by mattpetters on 7/13/17.
 */
public class CreateRecipeViewController {
	
	//recipe name
	//search for ingredients
	//ingredients in recipe
	//steps
	
	Button addIngredientButton;
	Button saveRecipeButton;
	Button cancelRecipeButton;
	TableView recipeIngredientsView;
	TextField recipeName;
	TextField searchField;
	TextArea steps;
	
	
	IngredientRepository repo = new IngredientRepository();
	
	 private AnchorPane viewport;
	 
	 
	 
	 public void addIngredientButtonPressed(){
	        //find ingredient in db, add to recipe
		 
		 if (searchField.getText().length() > 0){
	            ArrayList<String> delimited = new ArrayList<String>();
	            delimited.addAll(Arrays.asList(searchField.getText().split("\\s*,\\s*")));
	            ArrayList<Ingredient> foundIngredient = repo.getByName(searchField.getText());
	            		if(foundIngredient.size() == 0){
	                recipeIngredientsView.setPlaceholder(new Label("No recipes found."));
			} 
	        else {
	            updateTableWithIngredient(foundIngredient);
	        }
	    }
	}
		 
    private void updateTableWithIngredient(ArrayList<Ingredient> foundIngredient) {
        recipeIngredientsView.getItems().setAll(foundIngredient);
    }
   
    
    public void steps() {
    	
    		ArrayList<String> recipeSteps = new ArrayList<String>();
    		recipeSteps.addAll(Arrays.asList(steps.getText().split("\\s*,\\s*")));
            
            	
		} 
	

	public void cancelButtonPressed() {
		
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
	
	public void saveButtonPressed() {
		
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
