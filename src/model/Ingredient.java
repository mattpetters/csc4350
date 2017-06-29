package model;
import java.util.*;
/**
 * Created by mattpetters on 6/29/17.
 */
public class Ingredient {
    /**
     * ID for the ingredient
     */
    Integer id;
    /**
     * Reference to the ingredient type
     */
    IngredientType type;
    /**
     * The name of the ingredient
     */
    String name;
    /**
     * Boolean that indicates if the ingredient contains meat
     */
    Boolean isMeat;
    /**
     * Boolean that indicates if the ingredient has been favorited
     */
    Boolean isFavorite;
    /**
     * Date that the ingredient was created
     */
    Date createdAt;
    /**
     * Name of the person who created the ingredient
     */
    String createdBy;

}
