package model.repository;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import model.Ingredient;
import java.util.*;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mattpetters on 7/12/17.
 */
public class IngredientRepository {

    private static IngredientRepository instance;
    Dao<Ingredient, String> ingredientsDao = DaoManager.createDao(SQLiteConnectionSource.connectionSource, Ingredient.class);

    protected IngredientRepository() throws SQLException {

    }

    public static IngredientRepository getInstance(){
        if (instance == null){
            try {
                instance = new IngredientRepository();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingredients = null;

        try {
            ingredients = ingredientsDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredients;
    }

    public void createIngredient(Ingredient ing){
        try {
            ingredientsDao.create(ing);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createIngredientIfNotExists(Ingredient ing){
        try {
            ingredientsDao.createIfNotExists(ing);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ingredient getIngredientById(Integer id){
        Ingredient ing = null;
        try {
            ing = ingredientsDao.queryForId(id.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ing;
    }

    public void updateIngredient(Ingredient ing){
        try {
            ingredientsDao.update(ing);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteIngredient(Ingredient ing){
        try {
            ingredientsDao.delete(ing);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
