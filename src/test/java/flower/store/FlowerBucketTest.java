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
        int price_1 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity_1 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower rose = new Flower(FlowerType.ROSE);
        rose.setPrice(price_1);
        FlowerPack flowerPack = new FlowerPack(rose, quantity_1);
        flowerBucket.addFlowerPAck(flowerPack);
        Assertions.assertEquals(price_1 * quantity_1, flowerBucket.getPrice());

        int price_2 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity_2 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower tulip = new Flower(FlowerType.TULIP);
        tulip.setPrice(price_2);
        FlowerPack flowerPack2 = new FlowerPack(tulip, quantity_2);
        flowerBucket.addFlowerPAck(flowerPack2);
        Assertions.assertEquals(price_1 * quantity_1 + price_2 * quantity_2, flowerBucket.getPrice());

    }
}
