package tech.jore.hrpg;

public interface Bag<ITEM> extends Iterable<ITEM> {

    int add(ITEM item);

    int size();

    void clear();

}