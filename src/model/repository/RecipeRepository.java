package model.repository;


import model.*;
import model.SQLiteDBHelper;

import java.util.*;


/**
 * Created by mattpetters on 7/15/17.
 */
public class RecipeRepository implements BaseRepository{
    SQLiteDBHelper helper = new SQLiteDBHelper();

    @Override
    public ArrayList<Recipe> getAll() {
        ArrayList<Recipe> recipes = helper.selectAllRecipes();
        return recipes;
    }

    @Override
    public Recipe getById(Integer id) {
        return null;
    }

    public ArrayList<Recipe> findByIngredientQuery(ArrayList<String> query){
        return helper.searchRecipes(query);
    }

    @Override
    public <T> void create(T obj) {
        helper.addRecipe((Recipe) obj);
    }

    @Override
    public <T> void update(T obj) {

    }

    @Override
    public <T> void delete(T obj) {

    }

    public void createRecipeSteps(Recipe recipe, RecipeStep step){
        helper.addRecipeStep(step, recipe);
    }

    public ArrayList<RecipeStep> getStepsForRecipe(Recipe recipe){
        return helper.selectRecipeSteps(recipe);
    }
    public ArrayList<RecipeIngredient> getIngredientsForRecipe(Recipe recipe){
        return helper.selectRecipeIngredients(recipe);
    }
}
