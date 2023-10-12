package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class StoreTest
{
    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testFilter(){
        Flower rose = new Flower(FlowerType.ROSE);
        Flower tulip = new Flower(FlowerType.TULIP);
        Flower chamomile = new Flower(FlowerType.CHAMOMILE);

        rose.setPrice(10);
        FlowerPack rose_pack = new FlowerPack(rose, 10);
        Assertions.assertEquals(100, rose_pack.getPrice());

        tulip.setPrice(5);
        FlowerPack tulip_pack = new FlowerPack(tulip, 10);
        Assertions.assertEquals(50, tulip_pack.getPrice());

        chamomile.setPrice(20);
        FlowerPack chamomile_pack = new FlowerPack(chamomile, 10);
        Assertions.assertEquals(200, chamomile_pack.getPrice());

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.addFlowerPack(rose_pack);
        flowerBucket.addFlowerPack(chamomile_pack);
        Assertions.assertEquals(300, flowerBucket.getPrice());

        store.addItem(rose_pack);
        store.addItem(tulip_pack);
        store.addItem(chamomile_pack);
        store.addItem(flowerBucket);

        PriceFilter priceFilter1 = new PriceFilter(0, 75);
        List<Item> res1 = new ArrayList<>();
        res1.add(tulip_pack);
        Assertions.assertTrue(priceFilter1 instanceof Filter);
        Assertions.assertEquals(store.search(priceFilter1), res1);

        PriceFilter priceFilter2 = new PriceFilter(75, 250);
        List<Item> res2 = new ArrayList<>();
        res2.add(rose_pack);
        res2.add(chamomile_pack);
        Assertions.assertTrue(priceFilter2 instanceof Filter);
        Assertions.assertEquals(store.search(priceFilter2), res2);

        PriceFilter priceFilter3 = new PriceFilter(300, 300);
        List<Item> res3 = new ArrayList<>();
        res3.add(flowerBucket);
        Assertions.assertTrue(priceFilter3 instanceof Filter);
        Assertions.assertEquals(store.search(priceFilter3), res3);

        PriceFilter priceFilter4 = new PriceFilter(0, 1000);
        List<Item> res4 = new ArrayList<>();
        res4.add(rose_pack);
        res4.add(tulip_pack);
        res4.add(chamomile_pack);
        res4.add(flowerBucket);
        Assertions.assertTrue(priceFilter4 instanceof Filter);
        Assertions.assertEquals(store.search(priceFilter4), res4);
    }
}
