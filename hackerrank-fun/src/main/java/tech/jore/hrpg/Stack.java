package tech.jore.hrpg;

public interface Stack<ITEM> {

    int push(ITEM item);
    ITEM pop();
    int size();
    void clear();
    
}