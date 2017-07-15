package model.repository;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import model.Ingredient;
import model.enums.DataSourceType;

import java.util.*;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mattpetters on 7/12/17.
 */
public class IngredientRepository implements BaseRepository {

//    private DataSourceType datasource = DataSourceType.ORMLite;
    private static IngredientRepository instance;
//    Dao<Ingredient, String> ingredientsDao = DaoManager.createDao(SQLiteConnectionSource.connectionSource, Ingredient.class);

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

    public ArrayList<Ingredient> getAll(){
        ArrayList<Ingredient> ingredients = null;


        return ingredients;
    }


    public Ingredient getById(Integer id){
        Ingredient ing = null;
//        try {
//            ing = ingredientsDao.queryForId(id.toString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return ing;
    }

    @Override
    public <T> void create(T object) {

    }

    @Override
    public <Ingredient> void createIfNotExists(Ingredient object) {

    }

    @Override
    public <Ingredient> void update(Ingredient object) {

    }

    @Override
    public <Ingredient> void delete(Ingredient object) {

    }
}
