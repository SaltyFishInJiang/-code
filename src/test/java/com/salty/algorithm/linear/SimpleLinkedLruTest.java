package com.salty.algorithm.linear;

import com.salty.algorithm.linear.linkedlist.LruCache;
import org.junit.Test;
import org.springframework.util.Assert;

public class SimpleLinkedLruTest {

    @Test
    public void test() {
        LruCache cache = new LruCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        Assert.isTrue(cache.get(2) == 2);
        Assert.isTrue(cache.get(1) == 1);
        Assert.isTrue(cache.get(4) == -1);
        cache.put(2, 4);
        Assert.isTrue(cache.get(2) == 4);
        cache.put(4, 4);
        Assert.isTrue(cache.get(4) == 4);
        Assert.isTrue(cache.get(3) == -1);
        cache.put(5, 5);
        Assert.isTrue(cache.get(1) == -1);
        cache.put(6, 6);
        Assert.isTrue(cache.get(2) == -1);
    }
}