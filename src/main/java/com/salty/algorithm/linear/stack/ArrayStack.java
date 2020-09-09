package com.salty.algorithm.linear.stack;

import java.util.Arrays;

/**
 * @author ryan
 * @since 2020/09/09
 */
public class ArrayStack<T> implements Stack<T> {

    private Object[] elements = new Object[16];

    private int size = 0;

    @Override
    public void push(T item) {
        _addElement(item);
    }

    @Override
    public T pop() {
        return _removeElement();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        return (T) elements[size - 1];
    }

    private void _addElement(T item) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size << 1);
        }
        elements[size++] = item;
    }

    private T _removeElement() {
        if (size == 0) {
            return null;
        }
        T element = (T) elements[size - 1];
        elements[size-- - 1] = null;
        return element;
    }
}
