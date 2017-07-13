package model;

/**
 * Created by mattpetters on 6/29/17.
 */

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Model for ingredient types
 */
@DatabaseTable (tableName = "IngredientTypes")
public class IngredientType {
	@DatabaseField (generatedId = true)
    Integer id;
	@DatabaseField
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
