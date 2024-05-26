import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Кратерная булка", 100f},
                {"", Float.MAX_VALUE},
                {null, 100f},
                {"Кратерная булка Кратерная булка Кратерная булка Кратерная булка Кратерная булка", Float.MIN_VALUE},
                {"$Кр@терн@я#булка!", -1},
                {"Кратерная булка", 0}
        };
    }

    @Test
    public void getNameReturnName() {
        Bun bun = new Bun(name, price);
        String expectedName = name;
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnPrice() {
        Bun bun = new Bun(name, price);
        float expectedPrice = price;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0f);
    }

}