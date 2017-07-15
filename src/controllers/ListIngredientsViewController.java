package controllers;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Ingredient;
import model.Recipe;
import model.repository.IngredientRepository;

/**
 * Created by mattpetters on 7/13/17.
 */
public class ListIngredientsViewController {
	

public class IngredientsViewController {

    @FXML
	TableView ingredientTableView;
    @FXML
	TableColumn ingredientColumn;
    @FXML
	TextField nameField;
    @FXML
    Button addButton;
    @FXML
    CheckBox isMeatCheckbox;

   
	IngredientRepository repo = new IngredientRepository();
	
    
    public Boolean isMeatBoxChecked(){
        Boolean checked = isMeatCheckbox.isSelected();
        return checked;

    }
	
	
    public void addButtonPressed(){
        //create new ingredient
        //create new recipe
        Ingredient newIngredient = new Ingredient();
        newIngredient.setName(nameField.getText());
        repo.create(newIngredient);
        //update table
        configureTable();

 

      
    }

    private void configureTable(){
        ingredientColumn.setCellValueFactory(new PropertyValueFactory<Recipe,String>("name"));
        fetchLatestRecipes();
    }

    private void fetchLatestRecipes(){
        ArrayList<Ingredient> fetched = repo.getAll();
        ObservableList<Ingredient> viewRecipes = FXCollections.observableArrayList(fetched);
        ingredientTableView.setItems(viewRecipes);
    }




}


}
