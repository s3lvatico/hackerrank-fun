package tech.jore.hrpg;

import java.util.Iterator;
import java.util.NoSuchElementException;

class BagImpl<ITEM> implements Bag<ITEM> {

    private int size;

    private Node first;
    private Node last;

    private class Node {
        ITEM value;
        Node next;
    }

    private class BagIterator implements Iterator<ITEM> {
        private Node currentNode;

        BagIterator() {
            currentNode = null;
        }

        @Override
        public boolean hasNext() {
            if (currentNode == null) {
                return first != null;
            } else {
                return currentNode.next != null;
            }
        }

        @Override
        public ITEM next() {
            if (hasNext()) {
                if (currentNode == null) {
                    ITEM value = first.value;
                    currentNode = first;
                    return value;
                } else {
                    currentNode = currentNode.next;
                    return currentNode.value;
                }
            } else {
                throw new NoSuchElementException();
            }
        }

    }

    @Override
    public Iterator<ITEM> iterator() {
        return new BagIterator();
    }

    @Override
    public int add(ITEM item) {
        if (item != null) {
            if (first == null) {
                first = new Node();
                first.value = item;
                first.next = null;
                last = first;
            } else {
                Node n = new Node();
                n.value = item;
                n.next = null;
                last.next = n;
                last = n;
            }
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
        first = null;
        last = null;
        size = 0;
    }

}