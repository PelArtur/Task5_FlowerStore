package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        Assertions.assertTrue(flowerBucket instanceof Item);
        int price_1 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity_1 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower rose = new Flower(FlowerType.ROSE);
        rose.setPrice(price_1);
        FlowerPack flowerPack = new FlowerPack(rose, quantity_1);
        flowerBucket.addFlowerPack(flowerPack);
        Assertions.assertEquals(price_1 * quantity_1, flowerBucket.getPrice());

        int price_2 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity_2 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower tulip = new Flower(FlowerType.TULIP);
        tulip.setPrice(price_2);
        FlowerPack flowerPack2 = new FlowerPack(tulip, quantity_2);
        flowerBucket.addFlowerPack(flowerPack2);
        Assertions.assertEquals(price_1 * quantity_1 + price_2 * quantity_2, flowerBucket.getPrice());

        int price_3 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity_3 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower chamomile = new Flower(FlowerType.CHAMOMILE);
        chamomile.setPrice(price_3);
        FlowerPack flowerPack3 = new FlowerPack(chamomile, quantity_3);
        flowerBucket.addFlowerPack(flowerPack3);
        Assertions.assertEquals(price_1 * quantity_1 + price_2 * quantity_2 + price_3 * quantity_3, flowerBucket.getPrice());
    }
}
