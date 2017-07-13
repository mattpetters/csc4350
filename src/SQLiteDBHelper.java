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
selectRecipeSteps()
selectRecipeIngredients()
*/

public class SQLiteDBHelper {
	
    public static void main(String[] args){
    	SQLiteDBHelper test = new SQLiteDBHelper();
    	
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
    	
    	
    	// test.createTables();
    	// test.addIngredient(null);
    	// test.deleteIngredient(null);
    	// test.addRecipe(null);
    }
	
    private Connection connect() {
        // SQLite connection string
        //todo: get project root and set there
        String loc = "jdbc:sqlite:"+System.getProperty("user.dir") + "potlucktest.db";
//        String loc = "jdbc:sqlite:C:\\Users\\Adam\\workspace\\potlucktest.db"; // you'll need to change this
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
    
    public void createTables(){ // I don't think I'll need this
    	String sql = "CREATE TABLE [ingredient_lst] ([Id] INTEGER NOT NULL, [ingredient_name] TEXT NOT NULL, [ingredient_type_id] INTEGER NOT NULL, [is_meat] INTEGER NOT NULL, [favorite] INTEGER NULL, [hide] INTEGER NULL, [created_dt] TEXT NOT NULL, [created_by] TEXT NOT NULL, CONSTRAINT [PK_ingredient_lst] PRIMARY KEY ([Id]), FOREIGN KEY(ingredient_type_id) REFERENCES ingredient_type_lst(Id));";
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){      
               System.out.println("Table Create Success");
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
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
    		
               // System.out.println("Query Success");
               
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
     * addIngredient() will accept an Ingredient object 
     * It will insert this ingredient into DB table ingredient_lst 
     */
    public boolean addIngredient(Ingredient ingredient){
    	String ingredient_name = ingredient.getName();	
    	IngredientType ingredient_type_id = ingredient.getType();	
    	Boolean is_meat = ingredient.getIsMeat();	
    	Boolean favorite = ingredient.getIsFavorite();
    	int hide = 0; ingredient.getIsHidden();	
    	String created_dt = "today";	
    	String created_by = "user";

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
    	String created_by = "user"; 

    	String sql = "INSERT INTO recipe_lst(recipe_name,active_time,idle_time,total_time,serves,user_defined,favorite,hide,create_dt,create_by)"
    			+ "VALUES('" + recipe_name + "'," + active_time + "," + idle_time + "," + total_time + "," + serves + "," + user_defined + "," + favorite + "," + hide + ",'" + created_dt + "','" + created_by + "')";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Add Recipe Success");
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
	 * addRecipeStep will accept a RecipeStep object and will insert it into the DB table recipe_steps
	 */
	public void addRecipeStep(RecipeStep r){
		// Integer id = r.getId();
		Integer orderNumber = r.getOrderNumber();
		String description = r.getDescription();
		Recipe recipe = r.getRecipe();

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
