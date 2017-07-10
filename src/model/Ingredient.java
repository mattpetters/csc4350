package model;
import java.util.*;
/**
 * Created by mattpetters on 6/29/17.
 */

//none of these variables can have DATE type. SQLite doesn't offer that --Adam

/**
 * Model for ingredients
 */
public class Ingredient {
    Integer id; //ID for the ingredient
    IngredientType type; //Reference to the ingredient type
    String name; //The name of the ingredient
    Boolean isMeat; //Boolean that indicates if the ingredient contains meat
    Boolean isFavorite; //Boolean that indicates if the ingredient has been favorited
    Boolean isHidden; //Boolean that indicates if the ingredient has been hidden
    String createdAt; //Date that the ingredient was created
    String createdBy; //Name of the person who created the ingredient
	
    public Boolean getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public IngredientType getType() {
		return type;
	}
	public void setType(IngredientType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsMeat() {
		return isMeat;
	}
	public void setIsMeat(Boolean isMeat) {
		this.isMeat = isMeat;
	}
	public Boolean getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String string) {
		this.createdAt = string;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}    
}
