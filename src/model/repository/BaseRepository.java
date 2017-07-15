package model.repository;
import java.util.*;

/**
 * Created by mattpetters on 7/15/17.
 */
public interface BaseRepository {

    public <T> ArrayList<T> getAll();
    public <T> T getById(Integer id);
    public <T> void create(T obj);
    public  <T> void update(T obj);
    public  <T> void delete(T obj);
}
