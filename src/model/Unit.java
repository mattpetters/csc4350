package model;

/**
 * Created by mattpetters on 6/29/17.
 */

public class Unit {
    Integer id; //ID for the unit
    String name; //Name of the ingredient unit
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
