//lkjlj
package controllers;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;
import model.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mattpetters on 6/29/17.
 */

/**
 * View Controller for searching for recipes
 */
public class FindRecipeViewController {

    @FXML
    TableView tableView;
    @FXML
    TextField searchField;
    @FXML
    Button searchButton;

    RecipeRepository repo = new RecipeRepository();

    /**
     * Finds a recipe with given ingredients
     * @pre:
     * @post:
     * @return Recipe that matches ingredients
     */

//    public Recipe findRecipeForIngredients(ArrayList<Ingredient> ingredients){}


    /**
     * Responds to Search button pressed
     * @pre:
     * @post:
     * @return
     */

    public void searchButtonPressed(){

        if (searchField.getText().length() > 0){
            ArrayList<String> delimited = new ArrayList<String>();
            delimited.addAll(Arrays.asList(searchField.getText().split("\\s*,\\s*")));
            ArrayList<Recipe> foundRecipes = repo.findByIngredientQuery(delimited);
            if(foundRecipes.size() == 0){
                tableView.setPlaceholder(new Label("No recipes found."));

            } else {
                updateTableWithNewRecipes(foundRecipes);
            }
        }
    }

    private void updateTableWithNewRecipes(ArrayList<Recipe> foundRecipes) {
        tableView.getItems().setAll(foundRecipes);
    }


}
