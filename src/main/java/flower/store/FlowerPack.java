package flower.store;

import lombok.Getter;

@Getter
public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flower){
        this.flower = flower;
        this.quantity = 1;
    }

    public FlowerPack(Flower flower, int quantity){
        this.flower = flower;
        setQuantity(quantity);
    }

    public void setQuantity(int quantity){
        this.quantity = Math.max(quantity, 1);
    }

    public double getPrice(){
        return flower.getPrice() * quantity;
    }


}