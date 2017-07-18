package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Ingredient;
import model.*;
import model.RecipeStep;
import model.repository.RecipeRepository;
import java.util.*;

import javax.xml.soap.Text;

/**
 * Created by mattpetters on 7/13/17.
 */
public class EditRecipeViewController {

    @FXML
    Text recipesText;

    @FXML
    Text ingredientsText;

    @FXML
    Text stepsText;

    Recipe theRecipe = new Recipe();

    RecipeRepository recipeRepo = new RecipeRepository();

    @FXML
    public void initialize(){
        configureLabels();
    }


    public void configureLabels(){
        ArrayList<RecipeStep> steps = recipeRepo.getStepsForRecipe(theRecipe);
        ArrayList<RecipeIngredient> ings = recipeRepo.getIngredientsForRecipe(theRecipe);
        recipesText.setTextContent(theRecipe.getName());
        for (RecipeStep step:
            steps ) {
            stepsText.setTextContent(stepsText.getTextContent()+step.getDescription());
        }
        for (RecipeIngredient ing:
                ings ) {
            ingredientsText.setTextContent(ingredientsText.getTextContent()+ing.getIngredientName());
        }

    }
}
