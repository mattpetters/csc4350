package model.repository;

import model.Ingredient;

import java.util.ArrayList;

/**
 * Created by mattpetters on 7/13/17.
 */
public interface BaseRepository {
    public <T> ArrayList<T> getAll();
    public <T> void create(T object);
    public <T> void createIfNotExists(T object);
    public <T> T getById(Integer id);
    public <T> void update(T object);
    public <T> void delete(T object);
}
