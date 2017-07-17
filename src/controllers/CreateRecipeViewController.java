package controllers;

import java.io.IOException;
import java.lang.reflect.Array;
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

import javax.xml.soap.Text;

/**
 * Created by mattpetters on 7/13/17.
 */
public class CreateRecipeViewController {
	
	//recipe name
	//search for ingredients
	//ingredients in recipe
	//steps

	@FXML
	TextField recipeNameTextField;

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
   
    
    public ArrayList<RecipeStep> parseSteps(Integer recipeId) {
		ArrayList<String> recipeSteps = new ArrayList<String>();
		ArrayList<RecipeStep> steps = new ArrayList<RecipeStep>();
   		recipeSteps.addAll(Arrays.asList(stepsTextArea.getText().split("\\s*,\\s*")));
		for (String str:
			 recipeSteps) {
			RecipeStep step = new RecipeStep();
			step.setDescription(str);
			step.setRecipeId(recipeId);
			steps.add(step);
		}
		return steps;
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
		Recipe newRecipe = new Recipe();
		newRecipe.setName(recipeNameTextField.getText());
		ArrayList<RecipeStep> recipeSteps = parseSteps(newRecipe.getId());

		//save recipe to db
		recipeRepo.create(newRecipe);

		//save steps to db
		for (RecipeStep step:
			 recipeSteps) {
			recipeRepo.createRecipeSteps(newRecipe,step);
		}

		//nav to list view
	 	System.out.println("Save button pressed");
//	    Parent recipeView = null;
//	    try {
//	        recipeView = FXMLLoader.load(getClass().getResource("../views/ListRecipesView.fxml"));
//	        viewport.getChildren().setAll(recipeView);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
	}
		 
	
		      
		    
	
	}
