package model;

/**
 * Created by mattpetters on 6/29/17.
 */

/**
 * Model for Recipe Steps
 */
public class RecipeStep {
	
	// none of these variables can have DATE type. SQLite doesn't offer that --Adam
	Integer id; //ID for the recipe step
    Integer orderNumber; //Order number for the recipe step in which it should be completed. Must be >= 1.
    String description; //Description of the step. String that contains instructions for how to complete the step.
    Recipe recipe; //Reference to the recipe that owns this recipe step
    Integer recipeId;
    
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
