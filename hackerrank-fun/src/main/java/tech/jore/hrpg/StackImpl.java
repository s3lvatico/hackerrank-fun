package tech.jore.hrpg;

class StackImpl<ITEM> implements Stack<ITEM> {

    private Node top;
    private int size;

    private class Node {
        ITEM value;
        Node next;
    }

    @Override
    public ITEM pop() {
        if (top == null)
            return null;
        ITEM item = top.value;
        top = top.next;
        size--;
        return item;
    }

    @Override
    public int push(ITEM item) {
        if (item != null) {
            Node n = new Node();
            n.value = item;
            n.next = top;
            top = n;
            size++;
        }
        return size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

}