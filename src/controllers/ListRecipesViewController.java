package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Recipe;
import model.repository.RecipeRepository;
import javafx.scene.control.cell.PropertyValueFactory;
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
        if (recipeTableView != null){
            configureTable();
        }

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
        configureTable();

    }

    private void configureTable(){
        recipeColumn.setCellValueFactory(new PropertyValueFactory<Recipe,String>("name"));
        fetchLatestRecipes();
    }

    private void fetchLatestRecipes(){
        ArrayList<Recipe> fetchedRecipes = repo.getAll();
        ObservableList<Recipe> viewRecipes = FXCollections.observableArrayList(fetchedRecipes);
        recipeTableView.setItems(viewRecipes);
    }


}
