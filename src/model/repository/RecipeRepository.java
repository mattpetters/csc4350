package model.repository;

import java.util.ArrayList;

/**
 * Created by mattpetters on 7/13/17.
 */
public class RecipeRepository implements BaseRepository {
    @Override
    public <T> ArrayList<T> getAll() {
        return null;
    }

    @Override
    public <T> void create(T object) {

    }

    @Override
    public <T> void createIfNotExists(T object) {

    }

    @Override
    public <T> T getById(Integer id) {
        return null;
    }

    @Override
    public <T> void update(T object) {

    }

    @Override
    public <T> void delete(T object) {

    }
}
