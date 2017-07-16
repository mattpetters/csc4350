package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Recipe;
import model.repository.RecipeRepository;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mattpetters on 7/13/17.
 */
public class ListRecipesViewController {

    RecipeRepository repo = new RecipeRepository();

    @FXML
    Button addButton;

    @FXML
    TextField nameField;


    @FXML
    TableView recipeTableView;

	 private AnchorPane viewport;
	 
    public void addButtonPressed(){
        //create new recipe
        Recipe newRecipe = new Recipe();
        newRecipe.setName(nameField.getText());
        repo.create(newRecipe);
        
        //open createRecipeView
        System.out.println("Add button pressed");
	    Parent createRecipeView = null; 
	    try {
	    	createRecipeView = FXMLLoader.load(getClass().getResource("../views/CreateRecipeView.fxml"));
	        viewport.getChildren().setAll(createRecipeView);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    //update table
        ArrayList<Recipe> fetchedRecipes = repo.getAll();
        recipeTableView.getItems().setAll(fetchedRecipes);
        
        

    }


}
