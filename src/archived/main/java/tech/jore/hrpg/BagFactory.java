package tech.jore.hrpg;

public final class BagFactory {

    public static Bag<Integer> newIntegerBag() {
        return new BagImpl<Integer>();
    }
    
}