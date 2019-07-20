package org.gmnz.hackerrank;

public class JavaStack {

    private class Node {
        char value;
        Node next;
    }

    private Node top;
    private int size;

    public int push(char s) {
        Node n = new Node();
        n.value = s;
        n.next = top;
        top = n;
        return ++size;
    }

    public Character pop() {
        if (top == null) {
            return null;
        }
        char value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}