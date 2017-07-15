package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import model.*;

/*
 * created by Adam Pugliese
 * This SQLite DB helper will be used to add and remove items (recipes, steps, ingredients) to the DB.
 * It will also provide methods to select data from the DB.
 */

/*
TODO: 

mapRecipeIngredient()


*/

public class SQLiteDBHelper {
	
	public SQLiteDBHelper(){
		//nothing here
	}
	
	public static void main(String[] args){
		;
	}
	
	private void test(){
		
		
		/*
		 // TEST FOR SELECT RECIPE INGREDIENTS FOR A SPECIFIC RECIPE
		  
	    	Recipe bogus = new Recipe();
	    	bogus.setId(1);
	    	ArrayList<RecipeIngredient> recipeIngredients = new ArrayList<RecipeIngredient>(this.selectRecipeIngredients(bogus));
	    	System.out.println("ID\tRecipeID\tIngredientId\tIngredientName\tAmount\tUnitID\tUnitName"); // column labels
	    	for (int i = 0; i < recipeIngredients.size(); i++)
	    	{
	    		// System.out.println(rec.get(i).getName());
	    		System.out.println(recipeIngredients.get(i).getId() + "\t" 
						+ recipeIngredients.get(i).getId() + "\t"
						+ recipeIngredients.get(i).getRecipeId() + "\t"
						+ recipeIngredients.get(i).getIngredientId() + "\t"
						+ recipeIngredients.get(i).getIngredientName() + "\t"
						+ recipeIngredients.get(i).getAmount() + "\t"
						+ recipeIngredients.get(i).getUnitId() + "\t"
						+ recipeIngredients.get(i).getUnitName());
	    	}
	    	*/
	    	
	    	/*
	    	//TEST FOR SEARCH BY USER-PROVIDED INGREDIENTS
	    	 
	    	ArrayList<String> ingredientsThatUserHas = new ArrayList<String>();
	    	
	    	ingredientsThatUserHas.add("Sliced Ham");
	    	ingredientsThatUserHas.add("Sliced Cheese");
			//test.searchRecipes(ingredientsThatUserHas);
			ArrayList<Recipe> rec = new ArrayList<Recipe>(test.searchRecipes(ingredientsThatUserHas));
	    	System.out.println("ID\tName\tUserDefined\tFavorite\tHidden\tActiveTime\tIdleTIme\tTotalTime\tServes\tCreatedAt\tCreatedBy"); // column labels
	    	for (int i = 0; i < rec.size(); i++)
	    	{
	    		// System.out.println(rec.get(i).getName());
	    		System.out.println(rec.get(i).getId() + "\t" 
						+ rec.get(i).getName() + "\t"
						+ rec.get(i).getIsUserDefined() + "\t"
						+ rec.get(i).getIsFavorite() + "\t"
						+ rec.get(i).getIsHidden() + "\t"
						+ rec.get(i).getActiveTime() + "\t"
						+ rec.get(i).getIdleTime() + "\t"
						+ rec.get(i).getTotalTime() + "\t"
						+ rec.get(i).getServes() + "\t"
						+ rec.get(i).getCreatedAt() + "\t"
						+ rec.get(i).getCreatedBy());
	    	}
			*/
			
			
	    	/*
	    	// TEST FOR SELECT ALL INGREDIENTS
	    	 
	    	ArrayList<Ingredient> ing = new ArrayList<Ingredient>(test.selectAllIngredients());
	    	System.out.println("ID\tName\tType\tIsMeat\tFavorite\tHidden\tCreatedAt\tCreatedBy"); //column labels
	    	for (int i = 0; i < ing.size(); i++)
	    	{
	    		// System.out.println(ing.get(i).toString());
	    		System.out.println(ing.get(i).getId() + "\t" 
	    							+ ing.get(i).getName() + "\t"
	    							+ ing.get(i).getType() + "\t"
	    							+ ing.get(i).getIsMeat() + "\t"
	    							+ ing.get(i).getIsFavorite() + "\t"
	    							+ ing.get(i).getIsHidden() + "\t"
	    							+ ing.get(i).getCreatedAt() + "\t"
	    							+ ing.get(i).getCreatedBy());
	    	}
	    	
	    	// TEST FOR SELECT ALL RECIPES
	    	 
	    	ArrayList<Recipe> rec = new ArrayList<Recipe>(test.selectAllRecipes());
	    	System.out.println("ID\tName\tUserDefined\tFavorite\tHidden\tActiveTime\tIdleTIme\tTotalTime\tServes\tCreatedAt\tCreatedBy"); // column labels
	    	for (int i = 0; i < rec.size(); i++)
	    	{
	    		// System.out.println(rec.get(i).getName());
	    		System.out.println(rec.get(i).getId() + "\t" 
						+ rec.get(i).getName() + "\t"
						+ rec.get(i).getIsUserDefined() + "\t"
						+ rec.get(i).getIsFavorite() + "\t"
						+ rec.get(i).getIsHidden() + "\t"
						+ rec.get(i).getActiveTime() + "\t"
						+ rec.get(i).getIdleTime() + "\t"
						+ rec.get(i).getTotalTime() + "\t"
						+ rec.get(i).getServes() + "\t"
						+ rec.get(i).getCreatedAt() + "\t"
						+ rec.get(i).getCreatedBy());
	    	}
	    	*/
	    	
	    	// test.createTables();
	    	// test.addIngredient(null);
	    	// test.deleteIngredient(null);
	    	// test.addRecipe(null);
	}
	
	
    private Connection connect() {
        // SQLite connection string
        //todo: get project root and set there

        Boolean isUnixOS;
        if (System.getProperty("os.name").startsWith("Windows")) {
            isUnixOS = false;
        } else {
            isUnixOS = true;
        }
        String loc;
        if (isUnixOS){
        loc = "jdbc:sqlite:" + System.getProperty("user.dir") + "/potlucktest.db";
        } else {
            loc = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\potlucktest.db";
        }

        Connection c = null;
        try {
            c = DriverManager.getConnection(loc);
            System.out.println("Successful Connection");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
	
    /*
     * createTables() was initially intended to...create tables! but I think we should just package a prepared DB with the software.
     */
    
    public void createIngredientTable(){ 
    	String sql = "CREATE TABLE [ingredient_lst] "
    			+ "([Id] INTEGER NOT NULL, "
    			+ "[ingredient_name] TEXT NOT NULL, "
    			+ "[ingredient_type_id] INTEGER NOT NULL, "
    			+ "[is_meat] INTEGER NOT NULL, "
    			+ "[favorite] INTEGER NULL, "
    			+ "[hide] INTEGER NULL, "
    			+ "[created_dt] TEXT NOT NULL, "
    			+ "[created_by] TEXT NOT NULL, "
    			+ "CONSTRAINT [PK_ingredient_lst] PRIMARY KEY ([Id]), "
    			+ "FOREIGN KEY(ingredient_type_id) REFERENCES ingredient_type_lst(Id));";
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){      
               System.out.println("Table Create Success");
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
    }
    
    /*
     * selectAllIngredients() will return an ArrayList of Ingredient objects (all active/unhidden ingredients). 
     */
    public ArrayList<Ingredient> selectAllIngredients(){ 
    	ArrayList<Ingredient> ingredientLst = new ArrayList<Ingredient>();
    	String sql = "SELECT * from ingredient_lst WHERE hide != 1;";
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
    		
               System.out.println("Query Success");
               
               while (rs.next()) {

                   Ingredient ingredient = new Ingredient();
                   ingredient.setId(rs.getInt("id"));
                   ingredient.setName(rs.getString("ingredient_name"));
                   ingredient.setIsMeat(rs.getBoolean("is_meat"));
                   ingredient.setIsFavorite(rs.getBoolean("favorite"));
                   ingredient.setIsHidden(rs.getBoolean("hide"));
                   ingredient.setCreatedAt(rs.getString("created_dt"));
                   ingredient.setCreatedBy(rs.getString("created_by"));
                   
                   ingredientLst.add(ingredient);
               }
               //return recipeLst;
               
    	} catch (SQLException e) {
               System.out.println(e.getMessage());
    	}
    	return ingredientLst;
    }

    /*
	 * selectAllRecipes() will return an ArrayList of Recipe objects (all active/unhidden recipes). 
	 */
	public ArrayList<Recipe> selectAllRecipes(){ 
		ArrayList<Recipe> recipeLst = new ArrayList<Recipe>();
		String sql = "SELECT * from recipe_lst WHERE hide != 1;";
		
		try (Connection conn = this.connect();
	            Statement stmt  = conn.createStatement();
	            ResultSet rs    = stmt.executeQuery(sql)){
			
	            System.out.println("Query Success");
	           
	           while (rs.next()) {
	
	               Recipe recipe = new Recipe();
	               recipe.setId(rs.getInt("id"));
	               recipe.setName(rs.getString("recipe_name"));
	               recipe.setActiveTime(rs.getInt("active_time"));
	               recipe.setIdleTime(rs.getInt("idle_time"));
	               recipe.setTotalTime(rs.getInt("total_time"));
	               recipe.setServes(rs.getInt("serves"));
	               recipe.setIsUserDefined(rs.getBoolean("user_defined"));
	               recipe.setIsFavorite(rs.getBoolean("favorite"));
	               recipe.setIsHidden(rs.getBoolean("hide"));
	               recipe.setCreatedAt(rs.getString("create_dt"));
	               recipe.setCreatedBy(rs.getString("create_by"));
	               
	               recipeLst.add(recipe);
	           }
	           //return recipeLst;
	           
		} catch (SQLException e) {
	           System.out.println(e.getMessage());
		}
		return recipeLst;
	}

	/*
     * selectRecipeIngredients() will return an ArrayList of Ingredient objects assigned to a specific recipe (all active/unhidden ingredients). 
     */
    public ArrayList<RecipeIngredient> selectRecipeIngredients(Recipe chosenRecipe){ 
    	ArrayList<RecipeIngredient> ingredientLst = new ArrayList<RecipeIngredient>();
    	String sql = "Select ri.*, ul.unit_name, il.ingredient_name "
    			+ "from recipe_ingredients ri "
    			+ "join ingredient_lst il on ri.ingredient_id = il.Id "
    			+ "join unit_lst ul on ri.unit_id = ul.Id "
    			+ "where ri.recipe_id = " + chosenRecipe.getId() + ";";
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
    		
               System.out.println("Query Success");
               
               while (rs.next()) {

                   RecipeIngredient ingredient = new RecipeIngredient();
                   ingredient.setId(rs.getInt("id"));
                   ingredient.setRecipeId(rs.getInt("recipe_id"));
                   ingredient.setIngredientId(rs.getInt("ingredient_id"));
                   ingredient.setIngredientName(rs.getString("ingredient_name"));
                   ingredient.setAmount(rs.getFloat("amount"));
                   ingredient.setUnitId(rs.getInt("unit_id"));
                   ingredient.setUnitName(rs.getString("unit_name"));
                   
                   ingredientLst.add(ingredient);
               }
               //return recipeLst;
               
    	} catch (SQLException e) {
               System.out.println(e.getMessage());
    	}
    	return ingredientLst;
    }

    /*
     * selectRecipeSteps() will return an ArrayList of steps assigned to a specified recipe 
     */
    public ArrayList<RecipeStep> selectRecipeSteps(Recipe chosenRecipe){ // THIS SHIT IS NOT DONE!! 
    	ArrayList<RecipeStep> stepLst = new ArrayList<RecipeStep>();
    	String sql = "select "
    			+ "* "
    			+ "from recipe_steps "
    			+ "where recipe_id =" + chosenRecipe.getId() + ";";
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
    		
               System.out.println("Query Success");
               
               while (rs.next()) {

                   RecipeStep step = new RecipeStep();
                   step.setId(rs.getInt("Id"));
                   step.setRecipeId(rs.getInt("recipe_id"));
                   step.setOrderNumber(rs.getInt("order"));
                   step.setDescription(rs.getString("description"));
                                     
                   stepLst.add(step);
               }
               
    	} catch (SQLException e) {
               System.out.println(e.getMessage());
    	}
    	return stepLst;
    }
    
    
    /*
	 * selectSpecificIngredient() will return an ArrayList of Ingredient objects (all active/unhidden ingredients). 
	 */
	public ArrayList<Ingredient> selectSpecificIngredient(String searchString){ 
		ArrayList<Ingredient> ingredientLst = new ArrayList<Ingredient>();
		String sql = "SELECT * from ingredient_lst "
				+ "WHERE hide != 1 and lower(ingredient_name) like '%" + searchString.toLowerCase() + "%';";
		
		try (Connection conn = this.connect();
	            Statement stmt  = conn.createStatement();
	            ResultSet rs    = stmt.executeQuery(sql)){
			
	           System.out.println("Query Success");
	           
	           while (rs.next()) {
	
	               Ingredient ingredient = new Ingredient();
	               ingredient.setId(rs.getInt("id"));
	               ingredient.setName(rs.getString("ingredient_name"));
	               ingredient.setIsMeat(rs.getBoolean("is_meat"));
	               ingredient.setIsFavorite(rs.getBoolean("favorite"));
	               ingredient.setIsHidden(rs.getBoolean("hide"));
	               ingredient.setCreatedAt(rs.getString("created_dt"));
	               ingredient.setCreatedBy(rs.getString("created_by"));
	               
	               ingredientLst.add(ingredient);
	           }
	           //return recipeLst;
	           
		} catch (SQLException e) {
	           System.out.println(e.getMessage());
		}
		return ingredientLst;
	}

	/*
	 * selectAllRecipes() will return an ArrayList of Recipe objects (all active/unhidden recipes). 
	 */
	public ArrayList<Recipe> searchRecipes(ArrayList<String> ingredientsThatUserHas){ 
		
		ArrayList<Recipe> recipeLst = new ArrayList<Recipe>();
		int howMany = ingredientsThatUserHas.size();
		
		if (howMany == 0){
			// GTFO
		}
		
		String theBase = "select DISTINCT "
		+ "r.* from ingredient_lst i "
		+ "join recipe_ingredients ri on i.Id = ri.ingredient_id "
		+ "join recipe_lst r on ri.recipe_id = r.Id "
		+ "where exists "
		+ "(select * from recipe_ingredients ri0 "
		+ "join ingredient_lst il0 on ri0.ingredient_id = il0.Id "
		+ "where "
		+ "ri0.recipe_id = ri.recipe_id and "
		+ "lower(il0.ingredient_name) = '" + ingredientsThatUserHas.get(0).toLowerCase() +"') ";

		//loop the next few lines for n additional ingredients
		if (howMany > 1){
		for (int i = 1; i < howMany; i++)
		{
			String theTreble = "AND exists "
			+ "(select * from recipe_ingredients ri" + i + " "
			+ "join ingredient_lst il" + i + " on ri" + i + ".ingredient_id = il" + i + ".Id "
			+ "where "
			+ "ri" + i + ".recipe_id = ri.recipe_id "
			+ "and il" + i + ".ingredient_name = '" + ingredientsThatUserHas.get(i) + "') ";
			
			theBase += theTreble;
		}
		}
		
		String sql = theBase;
		
		try (Connection conn = this.connect();
	            Statement stmt  = conn.createStatement();
	            ResultSet rs    = stmt.executeQuery(sql)){
			
	            System.out.println("Query Success");
	           
	           while (rs.next()) {
	
	               Recipe recipe = new Recipe();
	               recipe.setId(rs.getInt("id"));
	               recipe.setName(rs.getString("recipe_name"));
	               recipe.setActiveTime(rs.getInt("active_time"));
	               recipe.setIdleTime(rs.getInt("idle_time"));
	               recipe.setTotalTime(rs.getInt("total_time"));
	               recipe.setServes(rs.getInt("serves"));
	               recipe.setIsUserDefined(rs.getBoolean("user_defined"));
	               recipe.setIsFavorite(rs.getBoolean("favorite"));
	               recipe.setIsHidden(rs.getBoolean("hide"));
	               recipe.setCreatedAt(rs.getString("create_dt"));
	               recipe.setCreatedBy(rs.getString("create_by"));
	               
	               recipeLst.add(recipe);
	           }
	           //return recipeLst;
	           
		} catch (SQLException e) {
	           System.out.println(e.getMessage());
		}
		return recipeLst;
	}

	/*
     * addIngredient() will accept an Ingredient object 
     * It will insert this ingredient into DB table ingredient_lst 
     */
    public boolean addIngredient(Ingredient ingredient){
    	String ingredient_name = ingredient.getName();	
    	IngredientType ingredient_type_id = ingredient.getType();	
    	Boolean is_meat = ingredient.getIsMeat();	
    	Boolean favorite = ingredient.getIsFavorite();
    	int hide = 0;	
    	String created_dt = "Date()";	
    	String created_by = System.getProperty("user.name");

    	String sql = "INSERT INTO ingredient_lst(ingredient_name,ingredient_type_id,is_meat,favorite,hide,created_dt,created_by)"
    			+ "VALUES('" + ingredient_name + "'," + ingredient_type_id + "," + is_meat + "," + favorite + "," + hide + ",'" + created_dt + "','" + created_by + "')";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            //System.out.println("Success");
        	return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /*
   	 * editRecipe() will accept a Recipe object and update the existing recipe in the DB to match
   	 */
   	public void editRecipe(Recipe recipe){
   		Integer Id = recipe.getId();
   		String recipe_name = recipe.getName();
   		Integer active_time = recipe.getActiveTime();	
   		Integer idle_time = recipe.getIdleTime();
   		Integer total_time = recipe.getTotalTime();
   		Integer serves = recipe.getServes();
   		Boolean user_defined = recipe.getIsUserDefined();
   		// Boolean favorite = recipe.getIsFavorite();
   		Boolean hide = recipe.getIsHidden();	
   		//String created_dt = "Date()"; // Date() is a SQLite function that will be passed in
   		//String created_by = System.getProperty("user.name"); 
   	
   		String sql = "UPDATE recipe_lst"
   				+ "SET Id = " + Id + ","
   				+ "recipe_name = " + recipe_name + ","
   				+ "active_time = " + active_time + ","
   				+ "idle_time = " + idle_time + ","
   				+ "total_time = " + total_time + ","
   				+ "serves = " + serves + ","
   				+ "user_defined = " + user_defined + ","
   				+ "hide = " + hide + " "
   				+ "WHERE Id = " + Id;
   				
   	    
   	    try (Connection conn = this.connect();
   	         Statement stmt  = conn.createStatement();
   	         ResultSet rs    = stmt.executeQuery(sql)){      
   	        System.out.println("Add Recipe Success");
   	    } catch (SQLException e) {
   	        System.out.println(e.getMessage());
   	    }
   	}
    
   	
   	/*
   	 * editIngredient() will accept an Ingredient object and update the existing ingredient in the DB to match
   	 */
    public boolean editIngredient(Ingredient ingredient){
    	Integer Id = ingredient.getId(); 
    	String ingredient_name = ingredient.getName();	
    	//IngredientType ingredient_type_id = ingredient.getType();	
    	Boolean is_meat = ingredient.getIsMeat();	
    	//Boolean favorite = ingredient.getIsFavorite();
    	Boolean hide = ingredient.getIsHidden(); 	
    	//String created_dt = "today";	
    	//String created_by = System.getProperty("user.name");

    	String sql = "UPDATE ingredient_lst SET ingredient_name = '" + ingredient_name + "',"
    			+ "is_meat = " + is_meat + ","
    			+ "hide = " + hide + " "
    			+ "WHERE ingredient_id = " + Id + ";";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            //System.out.println("Success");
        	return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    
    
    
    /*
	 * addRecipe() will accept a Recipe object
	 * It will insert this recipe into DB table recipe_lst 
	 */
	public void addRecipe(Recipe recipe){
		String recipe_name = recipe.getName();
		int active_time = recipe.getActiveTime();	
		int idle_time = recipe.getIdleTime();
		int total_time = recipe.getTotalTime();
		int serves = recipe.getServes();
		Boolean user_defined = recipe.getIsUserDefined();
		Boolean favorite = recipe.getIsFavorite();
		Boolean hide = recipe.getIsHidden();	
		String created_dt = "Date()"; // Date() is a SQLite function that will be passed in
		String created_by = System.getProperty("user.name"); 
	
		String sql = "INSERT INTO recipe_lst(recipe_name,active_time,idle_time,total_time,serves,user_defined,favorite,hide,create_dt,create_by)"
				+ "VALUES('" + recipe_name + "'," + active_time + "," + idle_time + "," + total_time + "," + serves + ",'" + user_defined + "','" + favorite + "','" + hide + "','" + created_dt + "','" + created_by + "')";
	    
	    try (Connection conn = this.connect();
	         Statement stmt  = conn.createStatement();
	         ResultSet rs    = stmt.executeQuery(sql)){      
	        System.out.println("Add Recipe Success");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}

	/*
	 * addRecipeStep will accept a RecipeStep object and will insert it into the DB table recipe_steps
	 */
	public void addRecipeStep(RecipeStep s, Recipe r ){
		// Integer id = r.getId();
		Integer orderNumber = s.getOrderNumber();
		String description = s.getDescription();
		Recipe recipe = r;
	
		String sql = "INSERT INTO recipe_steps(order,description,recipe_id)"
				+ "VALUES(" + orderNumber + ",'" + description + "'," + recipe.getId() + ")";
	    
	    try (Connection conn = this.connect();
	         Statement stmt  = conn.createStatement();
	         ResultSet rs    = stmt.executeQuery(sql)){      
	        System.out.println("Add Step Success");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	/*
	 * addRecipeStep will accept a RecipeStep object and will insert it into the DB table recipe_steps
	 */
	public void addRecipeIngredient(RecipeIngredient ri, Recipe r ){
		// Integer id = r.getId();
		Integer recipeId = r.getId();
		Integer ingredientId = ri.getIngredientId();
		Float amount = ri.getAmount();
		Integer unitId = ri.getUnitId();
	
		String sql = "INSERT INTO recipe_ingredients(recipe_id,ingredient_id,amount,unit_id)"
				+ "VALUES(" + recipeId + "," + ingredientId + "," + amount + "," + unitId + ")";
	    
	    try (Connection conn = this.connect();
	         Statement stmt  = conn.createStatement();
	         ResultSet rs    = stmt.executeQuery(sql)){      
	        System.out.println("Add Step Success");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}

	/*
     * deleteIngredient() will accept a alleged ingredient and will "delete" it from the DB.
     * But instead of deleting, it will update hide = 1 on ingredient_lst table for the ingredient.
     * It will also set hide = 1 on any recipes (in recipe_ingredients) that feature the ingredient.
     */
    public void deleteIngredient(Ingredient ingredient){ //won't really delete it. will update hide = 1 in ingredient_lst
    	int ingredient_id = ingredient.getId();
  
    	/*
    	String ingredient_name = ingredient.getName();	
    	IngredientType ingredient_type_id = ingredient.getType();	
    	Boolean is_meat = ingredient.getIsMeat();	
    	Boolean favorite = ingredient.getIsFavorite();
    	int hide = 0; ingredient.getIsHidden();	
    	Date created_dt = ingredient.getCreatedAt();	
    	String created_by = ingredient.getCreatedBy();
		*/

    	String sql = "UPDATE ingredient_lst SET hide = 1 where id = " + ingredient_id + ";";
        
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Hide Ingredient Success 1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        sql = "UPDATE recipe_ingredients SET hide = 1 where ingredient_id = " + ingredient_id + ";";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Hide Ingredient Success 2");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    /*
     * deleteRecipe() will accept a recipe obj and will "delete" it from the DB.
     * But instead of deleting, it will update hide = 1 on recipe_lst table for the ingredient.
     * It will also set hide = 1 on any instance of the recipe in recipe_ingredients
     */
   
	public void deleteRecipe(Recipe y){ //won't really delete it. will update hide = 1 in ingredient_lst
		int recipe_id = y.getId();
		/*
    	String recipe_name = y.getName();	
    	int active_time = y.getActiveTime();	
    	int idle_time = y.getIdleTime();
    	int total_time = y.getTotalTime();
    	int serves = y.getServes();
    	Boolean user_defined = y.getIsUserDefined();
    	Boolean favorite = y.getIsFavorite();
    	Boolean hide = y.getIsHidden();	
    	Date created_dt = y.getCreatedAt();
    	String created_by = y.getCreatedBy();
		*/

    	String sql = "UPDATE recipe_lst SET hide = 1 where id = " + recipe_id + ";";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Hide Recipe Success 1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        sql = "UPDATE recipe_ingredients SET hide = 1 where recipe_id = " + recipe_id + ";";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Hide Recipe Success 2");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	/*
	 * deleteRecipeStep will accept a RecipeStep object, and then delete it from the DB table recipe_steps
	 */
	public void deleteRecipeStep(RecipeStep r){
		Integer id = r.getId();
		/*
		Integer orderNumber = r.getOrderNumber();
		String description = r.getDescription();
		Recipe recipe = r.getRecipe();
		*/
		
    	String sql = "DELETE FROM recipe_steps WHERE Id = " + id + ";"; 
    			
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Successfully Deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }		

	
	
	
}
