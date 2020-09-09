package com.salty.algorithm.linear;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.util.Assert;


/**
 * 链表实现简单lru缓存
 * @author ryan
 * @since 2020/09/03
 */
@Data
public class LruCache {

    CacheList list;
    int cap;

    public LruCache(int cap) {
        list = new CacheList();
        this.cap = cap;
    }

    public int get(int key) {
        Node hit = _getNode(key);
        if (hit != null) {
            return hit.val;
        }
        return -1;
    }

    private Node _getNode(int key) {
        Node prev = null;
        Node node = list.getHead();
        while (node != null) {
            if (key != node.getKey()) {
                prev = node;
                node = node.next;
                continue;
            }
            _setHead(prev, node);
            return node;
        }
        return null;
    }

    private void _setHead(Node prev, Node node) {
        if (prev != null) {
            prev.next = node.next;
            node.next = list.getHead();
            list.head = node;
        }
    }

    public void put(int key, int value) {
        Node node = _getNode(key);
        if (node != null) {
            node.val = value;
            return;
        }
        if (cap == list.length) {
            _delNode();
        }
        list.head = new Node(key, value, list.head);
        list.length++;
    }

    private void _delNode() {
        Node node = list.head;
        Node prev = null;
        while (node != null && node.next != null) {
            prev = node;
            node = node.next;
        }
        if (prev != null) {
            list.length--;
            prev.next = null;
        }
    }

    @AllArgsConstructor
    @Getter
    static class Node {

        int key;

        int val;

        Node next;
    }

    @Data
    static class CacheList {

        Node head;

        int length = 0;
    }
}
