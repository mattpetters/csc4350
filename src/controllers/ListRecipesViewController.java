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
import javafx.scene.layout.VBox;
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
    Button addButton;

    @FXML
    TextField nameField;


    @FXML
    TableView recipeTableView;

    @FXML
    VBox listRecipesVBox;
	 
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


}
