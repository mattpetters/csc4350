package controllers;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import model.Ingredient;
import model.repository.IngredientRepository;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Created by mattpetters on 7/13/17.
 */
public class ListIngredientsViewController {


	@FXML
	TableView ingredientTableView;
	@FXML
	TextField nameField;
	@FXML
    Button addButton;
	@FXML
    CheckBox isMeatCheckbox;
    @FXML
    TableColumn ingredientColumn;

   
	IngredientRepository repo = new IngredientRepository();

	@FXML
    public void initialize(){
	    configureTable();
    }
	
    
    public Boolean isMeatBoxChecked(){
        Boolean checked = isMeatCheckbox.isSelected();
        return checked;

    }
	
	
    public void addButtonPressed(){
        //create new ingredient
        Ingredient newIngredient = new Ingredient();
        newIngredient.setName(nameField.getText());
        newIngredient.setIsMeat(isMeatBoxChecked());
        repo.create(newIngredient);
        //update table
        configureTable();
      
    }

    public void configureTable(){
        ingredientColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
        fetchLatestIngredients();

    }

    public void fetchLatestIngredients(){

        ArrayList<Ingredient> fetched = repo.getAll();
        ObservableList<Ingredient> viewIngredients = FXCollections.observableArrayList(fetched);
        ingredientTableView.setItems(viewIngredients);
    }




}
