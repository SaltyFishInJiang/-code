package com.salty.algorithm.linear.stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;

import java.util.Arrays;

/**
 * @author ryan
 * @since 2020/09/09
 */
public class LinkedStack<T> implements Stack<T> {

    private Node<T> head;

    private int size = 0;

    @Override
    public void push(T item) {
        head = new Node<>(item, head);
        size++;
    }

    @Override
    public T pop() {
        Node<T> res = head;
        head = head.next;
        size--;
        return res.val;
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
        return head.val;
    }



    @Data
    @AllArgsConstructor
    static class Node<T> {
        T val;

        Node<T> next;
    }
}
