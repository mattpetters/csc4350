package model;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.*;
/**
 * Created by mattpetters on 6/29/17.
 */

//none of these variables can have DATE type. SQLite doesn't offer that --Adam

/**
 * Model for ingredients
 */
@DatabaseTable (tableName = "Ingredients")
public class Ingredient {
	@DatabaseField (generatedId = true)
    Integer id; //ID for the ingredient
    IngredientType type; //Reference to the ingredient type
	@DatabaseField
    String name; //The name of the ingredient
    @DatabaseField
	Boolean isMeat; //Boolean that indicates if the ingredient contains meat
    @DatabaseField
	Boolean isFavorite; //Boolean that indicates if the ingredient has been favorited
    @DatabaseField
	Boolean isHidden; //Boolean that indicates if the ingredient has been hidden
    @DatabaseField
	Date createdAt; //Date that the ingredient was created
    @DatabaseField
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
