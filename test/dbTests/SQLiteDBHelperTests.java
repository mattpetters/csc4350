package dbTests;
import org.junit.Assert;
import org.junit.Test;
import model.*;

import java.util.ArrayList;

/**s
 * Created by mattpetters on 6/29/17.
 */
public class SQLiteDBHelperTests {

    SQLiteDBHelper helper = new SQLiteDBHelper();

    @Test
    public void addRecipeTest(){
        Boolean didAddSuccessfully = false;
        Recipe recipe = new Recipe();
        recipe.setName("New name");
        helper.addRecipe(recipe);
        ArrayList<Recipe> recipes = getRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            if (recipe.getName() == recipes.get(i).getName()){
                didAddSuccessfully = true;
            }
        }

        Assert.assertTrue(didAddSuccessfully == true);

    }

    private ArrayList<Recipe> getRecipes(){
        ArrayList<Recipe> recipes = helper.selectAllRecipes();
        return recipes;
    }

}
