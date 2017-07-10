package model;

/**
 * Created by mattpetters on 6/29/17.
 */

/**
 * Model for ingredient types
 */
public class IngredientType {
    Integer id;
    String type;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}    
}
