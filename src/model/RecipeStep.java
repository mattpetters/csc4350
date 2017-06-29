package model;

/**
 * Created by mattpetters on 6/29/17.
 */
public class RecipeStep {
    /**
     * ID for the recipe step
     */
    Integer id;
    /**
     * Order number for the recipe step in which it should be completed. Must be >= 1.
     */
    Integer orderNumber;
    /**
     * Description of the step. String that contains instructions for how to complete the step.
     */
    String description;
    /**
     * Reference to the recipe that owns this recipe step
     */
    Recipe recipe;
}
