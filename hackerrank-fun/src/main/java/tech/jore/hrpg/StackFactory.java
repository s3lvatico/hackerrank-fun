package tech.jore.hrpg;

public final class StackFactory {
    static Stack<Integer> newIntegerStack() {
        return new StackImpl<Integer>();
    }
}