import com.j256.ormlite.support.ConnectionSource;
import model.Ingredient;
import model.repository.IngredientRepository;
import model.repository.SQLiteConnectionSource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mattpetters on 6/27/17.
 */
public class IngredientRepositoryTests {

    @Test
    public void getAllIngredientsTest(){
        Assert.assertTrue(true);
    }

    @Test
    public void getIngredientByIDTest(){

    }

    @Test
    public void getIngredientsForRecipeTest(){
        Assert.assertTrue(true);
    }

    @Test
    public void createIngredientTest() {
        SQLiteConnectionSource source = new SQLiteConnectionSource();
        try {
            source.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Ingredient ing = new Ingredient();

        ing.setId(1);

        IngredientRepository.getInstance().createIngredientIfNotExists(ing);

        Ingredient fetchedIng = IngredientRepository.getInstance().getIngredientById(1);

        Assert.assertTrue( ing.getId() == fetchedIng.getId());

        IngredientRepository.getInstance().deleteIngredient(fetchedIng);

    }
}
