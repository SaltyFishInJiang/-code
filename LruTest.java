package com.demo.local.algorithm.linear;

import com.xingren.common.utils.Asserts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;


/**
 * @author ryan
 * @since 2020/09/03
 */
public class LruTest {

    public static void main(String[] args) {
        LruCache cache = new LruCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        Asserts.isTrue(cache.get(2) == 2);
        Asserts.isTrue(cache.get(1) == 1);
        Asserts.isTrue(cache.get(4) == -1);
        cache.put(2, 4);
        Asserts.isTrue(cache.get(2) == 4);
        cache.put(4, 4);
        Asserts.isTrue(cache.get(4) == 4);
        Asserts.isTrue(cache.get(3) == -1);
        cache.put(5, 5);
        Asserts.isTrue(cache.get(1) == -1);
        cache.put(6, 6);
        Asserts.isTrue(cache.get(2) == -1);

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

    @Data
    static class LruCache {
        CacheList list;
        int cap;

        public LruCache(int cap) {
             list = new CacheList();
             this.cap = cap;
        }

        public int get(int key) {
            Node hit = _getNode(key);
            if (hit != null) return hit.val;
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
            list.length ++;
        }

        private void _delNode() {
            Node node = list.head;
            Node prev = null;
            while (node != null && node.next != null) {
                prev = node;
                node = node.next;
            }
            if (prev != null) {
                list.length --;
                prev.next = null;
            }
        }
    }
}
