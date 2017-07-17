package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Ingredient;
import model.Recipe;
import model.repository.RecipeRepository;
import sun.applet.Main;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mattpetters on 7/13/17.
 */
public class ListRecipesViewController {
	

    RecipeRepository repo = new RecipeRepository();

    @FXML
    TableView recipeTableView;

    @FXML
    TableColumn recipeColumn;

    @FXML
    VBox listRecipesVBox;

    @FXML
    public void initialize(){
        configureTable();
    }


    public void newRecipeButtonPressed(){
        System.out.println("Attempting to transition to create recipe");
        Parent createRecipeView = null;
        try {
            createRecipeView = FXMLLoader.load(getClass().getResource("../views/CreateRecipeView.fxml"));
            listRecipesVBox.getChildren().setAll(createRecipeView);
            System.out.println("Change success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void configureTable(){
        recipeColumn.setCellValueFactory(new PropertyValueFactory<Recipe,String>("name"));
        fetchLatestRecipes();

    }

    public void fetchLatestRecipes(){

        ArrayList<Recipe> fetched = repo.getAll();
        ObservableList<Recipe> viewRecipes = FXCollections.observableArrayList(fetched);
        recipeTableView.setItems(viewRecipes);
    }


}
