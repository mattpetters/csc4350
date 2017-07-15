package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Recipe;
import model.repository.RecipeRepository;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    @FXML
    TableColumn recipeColumn;

    public ListRecipesViewController(){
        configureTable();
    }


    public Boolean isMeatBoxChecked(){
        Boolean checked = isMeatCheckbox.isSelected();
        return checked;

    }

    public void addButtonPressed(){
        //create new recipe
        Recipe newRecipe = new Recipe();
        newRecipe.setName(nameField.getText());
        repo.create(newRecipe);
        //update table
        ArrayList<Recipe> fetchedRecipes = repo.getAll();

        recipeColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.toString()));
        for (Recipe recipe:
             fetchedRecipes) {
            recipeTableView.getItems().add(recipe.getName());
        }


    }

    private void configureTable(){
    }


}
