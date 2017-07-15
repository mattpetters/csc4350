package model.repository;

import model.Recipe;
import model.SQLiteDBHelper;

import java.util.*;


/**
 * Created by mattpetters on 7/15/17.
 */
public class RecipeRepository implements BaseRepository{
    @Override
    public ArrayList<Recipe> getAll() {
        return null;
    }

    @Override
    public Recipe getById(Integer id) {
        return null;
    }

    public ArrayList<Recipe> findByIngredientQuery(ArrayList<String> query){
        return new SQLiteDBHelper().searchRecipes(query);
    }

    @Override
    public <T> void create(T obj) {

    }

    @Override
    public <T> void update(T obj) {

    }

    @Override
    public <T> void delete(T obj) {

    }
}
