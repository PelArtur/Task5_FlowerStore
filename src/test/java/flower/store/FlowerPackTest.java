package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Random;

public class FlowerPackTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    @Test
    public void testPrice() {
        int price_1 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity_1 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower rose = new Flower(FlowerType.ROSE);
        rose.setPrice(price_1);
        FlowerPack flowerPack1 = new FlowerPack(rose, quantity_1);
        Assertions.assertTrue(flowerPack1 instanceof Item);
        Assertions.assertEquals(price_1 * quantity_1, flowerPack1.getPrice());

        int price_2 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity_2 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower tulip = new Flower(FlowerType.TULIP);
        tulip.setPrice(price_2);
        FlowerPack flowerPack2 = new FlowerPack(tulip, quantity_2);
        Assertions.assertTrue(flowerPack2 instanceof Item);
        Assertions.assertEquals(price_2 * quantity_2, flowerPack2.getPrice());

        int price_3 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity_3 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower chamomile = new Flower(FlowerType.CHAMOMILE);
        chamomile.setPrice(price_3);
        FlowerPack flowerPack3 = new FlowerPack(chamomile, quantity_3);
        Assertions.assertTrue(flowerPack3 instanceof Item);
        Assertions.assertEquals(price_3 * quantity_3, flowerPack3.getPrice());
    }
}
