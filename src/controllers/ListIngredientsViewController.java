package controllers;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Ingredient;
import model.repository.IngredientRepository;

/**
 * Created by mattpetters on 7/13/17.
 */
public class ListIngredientsViewController {
	

public class IngredientsViewController {
	
	TableView ingredientTableView;
	TextField nameField;
    Button addButton;
    CheckBox isMeatCheckbox;

   
	IngredientRepository repo = new IngredientRepository();
	
    
    public Boolean isMeatBoxChecked(){
        Boolean checked = isMeatCheckbox.isSelected();
        return checked;

    }
	
	
    public void addButtonPressed(){
        //create new ingredient
        Ingredient newIngredient = new Ingredient();
        newIngredient.setName(nameField.getText());
        repo.create(newIngredient);
        //update table
        ArrayList<Ingredient> fetchedIngredients = repo.getAll();
        ingredientTableView.getItems().setAll(fetchedIngredients);

 

      
    }

}


}
