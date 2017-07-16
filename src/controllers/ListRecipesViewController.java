package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Recipe;
import model.repository.RecipeRepository;

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
    CheckBox isMeatCheckbox;

    @FXML
    TableView recipeTableView;

    public void addButtonPressed(){
        //create new recipe

    }

    public void fetchLatestIngredients(){
        ArrayList<Recipe> fetchedRecipes = repo.getAll();
        ObservableList<Recipe> viewRecipes = FXCollections.observableArrayList(fetchedRecipes);
        recipeTableView.setItems(viewRecipes);

    }


}
