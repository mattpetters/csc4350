package model.repository;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Ingredient;

import java.sql.SQLException;

/**
 * Created by mattpetters on 7/12/17.
 */
public class SQLiteConnectionSource {

    static public ConnectionSource connectionSource;

    public void initialize() throws Exception {
        String loc = "jdbc:sqlite:"+System.getProperty("user.dir") + "/database.sqlite";
        connectionSource = new JdbcConnectionSource(loc);
        createTables();
    }

    public void createTables() {

        try {
            TableUtils.createTableIfNotExists(connectionSource, Ingredient.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
