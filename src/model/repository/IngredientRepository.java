package model.repository;
//import com.j256.ormlite.dao.Dao;
//import com.j256.ormlite.dao.DaoManager;
//import com.j256.ormlite.support.ConnectionSource;

import model.Ingredient;
import model.Recipe;
import model.SQLiteDBHelper;

import java.util.*;
import java.sql.SQLException;
import java.util.ArrayList;
 
/**
 * Created by mattpetters on 7/12/17.
 */
public class IngredientRepository implements BaseRepository{
    SQLiteDBHelper helper = new SQLiteDBHelper();

    @Override
    public ArrayList<Ingredient> getAll() {
        ArrayList<Ingredient> ingredients = helper.selectAllIngredients();
        return ingredients;
    }

    @Override
    public Ingredient getById(Integer id) {
        return helper.selectIngredientByID(id);
    }
    
 
    public ArrayList<Ingredient> getByName(String text) {
        return helper.selectSpecificIngredient(text);
    }

    @Override
    public <T> void create(T obj) {
        helper.addIngredient((Ingredient) obj);
    }

    @Override
    public <T> void update(T obj) {

    }

    @Override
    public <T> void delete(T obj) {

    }

	
}
