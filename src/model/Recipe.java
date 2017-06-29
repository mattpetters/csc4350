package model;
import java.util.*;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by mattpetters on 6/29/17.
 */
public class Recipe {
    /**
     * Name of the recipe
     */
    String name;
    /**
     * Boolean value indicating whether the recipe was user defined
     */
    Boolean isUserDefined;
    /**
     * Boolean value indicating whether the recipe was favorited
     */
    Boolean isFavorite;
    /**
     * Date the recipe was created
     */
    Date createdAt;
    /**
     * String that is the name of the person who created the recipe
     */
    String createdBy;
    /**
     * Total time to cook (number of minutes)
     */
    Integer totalTime;
    /**
     * Active time to cook (number of minutes)
     */
    Integer activeTime;
    /**
     * Idle time to cook (number of minutes)
     */
    Integer idleTime;


}
