package model;
import java.util.*;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by mattpetters on 6/29/17.
 */
public class Recipe {
	Integer id; // recipe_id
    String name; //Name of the recipe
    Boolean isUserDefined; //Boolean value indicating whether the recipe was user defined
    Boolean isFavorite; //Boolean value indicating whether the recipe was favorited
    Boolean isHidden; // Boolean value indicating whether the recipe was hidden
	Integer activeTime; //Active time to cook (number of minutes)
    Integer idleTime; //Idle time to cook (number of minutes)
    Integer totalTime; //Total time to cook (number of minutes)
	Integer serves; //# of servings
    Date createdAt; //Date the recipe was created
    String createdBy; //String that is the name of the person who created the recipe
	
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
	public Boolean getIsUserDefined() {
		return isUserDefined;
	}
	public void setIsUserDefined(Boolean isUserDefined) {
		this.isUserDefined = isUserDefined;
	}
	public Boolean getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	
    public Boolean getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}
	public Integer getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(Integer activeTime) {
		this.activeTime = activeTime;
	}
	public Integer getIdleTime() {
		return idleTime;
	}
	public void setIdleTime(Integer idleTime) {
		this.idleTime = idleTime;
	}
	
	public Integer getServes() {
		return serves;
	}
	
	public void setServes(Integer serves) {
		this.serves = serves;
		}
}
