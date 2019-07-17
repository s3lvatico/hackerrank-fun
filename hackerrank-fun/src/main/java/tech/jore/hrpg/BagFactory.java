package tech.jore.hrpg;

public final class BagFactory {
    static Bag<Integer> newIntegerBag() {
        return new BagImpl<Integer>();
    }
}