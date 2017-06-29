import java.sql.*;

public class SQLiteDBHelper {
	
    public static void main(String[] args){
    	SQLiteDBHelper test = new SQLiteDBHelper();
    	// test.createTables();
    	// test.addIngredient(null);
    	// test.deleteIngredient(null);
    	// test.addRecipe(null);
    }
	
    private Connection connect() {
        // SQLite connection string
        String loc = "jdbc:sqlite:C:\\Users\\Adam\\workspace\\potlucktest.db"; // you'll need to change this
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
     * addIngredient() will accept an object (that is hopefully an ingredient). 
     * It will insert this ingredient into DB table ingredient_lst 
     */
    public void addIngredient(Object ingredient){
    	String ingredient_name = "Lion Steak"; // ingredient.getName();	
    	int ingredient_type_id = 1; // ingredient.getType();	
    	int is_meat = 1; // ingredient.isMeat();	
    	int favorite = 1; // ingredient.isFavorite();
    	int hide = 0; // ingredient.hide();	
    	String created_dt = "today";	
    	String created_by = "user";

    	String sql = "INSERT INTO ingredient_lst(ingredient_name,ingredient_type_id,is_meat,favorite,hide,created_dt,created_by)"
    			+ "VALUES('" + ingredient_name + "'," + ingredient_type_id + "," + is_meat + "," + favorite + "," + hide + ",'" + created_dt + "','" + created_by + "')";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /*
     * deleteIngredient() will accept a alleged ingredient and will "delete" it from the DB.
     * But instead of deleting, it will update hide = 1 on ingredient_lst table for the ingredient.
     * It will also set hide = 1 on any recipes (in recipe_ingredients) that feature the ingredient.
     */
    public void deleteIngredient(Object ingredient){ //won't really delete it. will update hide = 1 in ingredient_lst
    	int ingredient_id = 27;
    	String ingredient_name = "Lion Steak"; // ingredient.getName();	
    	int ingredient_type_id = 1; // ingredient.getType();	
    	int is_meat = 1; // ingredient.isMeat();	
    	int favorite = 1; // ingredient.isFavorite();
    	int hide = 0; // ingredient.hide();	
    	String created_dt = "today";	
    	String created_by = "user";

    	String sql = "UPDATE ingredient_lst SET hide = 1 where id = " + ingredient_id + ";";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        sql = "UPDATE recipe_ingredients SET hide = 1 where ingredient_id = " + ingredient_id + ";";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /*
     * addRecipe() will accept an object (that is hopefully an recipe).
     * It will insert this recipe into DB table recipe_lst 
     */
    public void addRecipe(Object recipe){
    	String recipe_name = "Boot Soup"; // recipe.getName();	
    	int active_time = 1; // recipe.getActTime();	
    	int idle_time = 1; // recipe.getIdleTime();
    	int total_time = 1; // recipe.getTotalTime();
    	int serves = 4; // recipe.getServes();
    	int user_defined = 1; // recipe.getUDef();
    	int favorite = 1; // recipe.isFavorite();
    	int hide = 0; // recipe.hide();	
    	String created_dt = "today";	
    	String created_by = "user";

    	String sql = "INSERT INTO recipe_lst(recipe_name,active_time,idle_time,total_time,serves,user_defined,favorite,hide,create_dt,create_by)"
    			+ "VALUES('" + recipe_name + "'," + active_time + "," + idle_time + "," + total_time + "," + serves + "," + user_defined + "," + favorite + "," + hide + ",'" + created_dt + "','" + created_by + "')";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /*
     * deleteRecipe() will accept a recipe obj and will "delete" it from the DB.
     * But instead of deleting, it will update hide = 1 on recipe_lst table for the ingredient.
     * It will also set hide = 1 on any instance of the recipe in recipe_ingredients
     */
    public void deleteRecipe(Object ingredient){ //won't really delete it. will update hide = 1 in ingredient_lst
    	int recipe_id = 0; //recipe.getId();
    	String recipe_name = "Boot Soup"; // recipe.getName();	
    	int active_time = 1; // recipe.getActTime();	
    	int idle_time = 1; // recipe.getIdleTime();
    	int total_time = 1; // recipe.getTotalTime();
    	int serves = 4; // recipe.getServes();
    	int user_defined = 1; // recipe.getUDef();
    	int favorite = 1; // recipe.isFavorite();
    	int hide = 0; // recipe.hide();	
    	String created_dt = "today";	
    	String created_by = "user";

    	String sql = "UPDATE recipe_lst SET hide = 1 where id = " + recipe_id + ";";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        sql = "UPDATE recipe_ingredients SET hide = 1 where recipe_id = " + recipe_id + ";";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){      
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

