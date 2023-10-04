package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest
{
    private Ingredient ingredient;

    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price)
    {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest()
    {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Before
    public void setUp()
    {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getNameTest()
    {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest()
    {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest()
    {
        Assert.assertEquals(type, ingredient.getType());
    }
}
