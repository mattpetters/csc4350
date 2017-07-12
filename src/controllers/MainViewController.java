package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Controller for the initial entry point to the application
 */
public class MainViewController {

    @FXML
    private BorderPane navigationRoot;

    @FXML
    private AnchorPane viewport;

    /**
     * Navigates to a view
     * @pre:
     * @post: view navigates to an arbitrary view
     * @return
     *
     */

    public void navigateToView(){


    }

    /**
     * Responds to Find button pressed
     * @pre:
     * @post: View navigates to button view
     * @return
     */
    public void findButtonPressed(){

        System.out.println("Find button pressed");
        Parent findView = null;
        try {
            findView = FXMLLoader.load(getClass().getResource("../views/FindView.fxml"));
            viewport.getChildren().setAll(findView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Responds to Recipes button pressed
     *
     * @pre: none
     * @post: View navigates to recipes view
     * @return none
     */
    public void recipesButtonPressed(){

        System.out.println("Recipes button pressed");
        Parent recipeView = null;
        try {
            recipeView = FXMLLoader.load(getClass().getResource("../views/RecipeView.fxml"));
            viewport.getChildren().setAll(recipeView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Responds to Ingredients button pressed
     * @pre: none
     * @post: View navigates to ingredients view
     * @return none
     */
    public void ingredientsButtonPressed(){

        System.out.println("Ingredients button pressed");
        Parent ingredientsView = null;
        try {
            ingredientsView = FXMLLoader.load(getClass().getResource("../views/IngredientsView.fxml"));
            viewport.getChildren().setAll(ingredientsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Responds to Ingredients button pressed
     * @pre: none
     * @post: View navigates to ingredients view
     * @return none
     */
    public void importButtonPressed(){

        System.out.println("Import button pressed");
        Parent importView = null;
        try {
            importView = FXMLLoader.load(getClass().getResource("../views/ImportView.fxml"));
            viewport.getChildren().setAll(importView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
