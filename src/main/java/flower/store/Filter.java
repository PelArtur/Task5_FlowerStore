package flower.store;

public interface Filter {
    boolean match(Item item);
}
