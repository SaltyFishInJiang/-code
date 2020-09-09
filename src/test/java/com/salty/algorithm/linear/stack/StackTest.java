package com.salty.algorithm.linear.stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void arrayTest() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        _testStack(stack);
    }

    @Test
    public void linkedTest() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        _testStack(stack);
    }

    private void _testStack(Stack<Integer> stack) {
        for (int i = 0; i < 16; i++) {
            Assert.assertEquals(stack.size(), i);
            stack.push(i);
            Assert.assertEquals(stack.size(), i + 1);
        }
        Assert.assertEquals(stack.size(), 16);
        for (int i = 15; i >= 0; i--) {
            Assert.assertEquals(stack.size(), i + 1);
            assertEquals((int) stack.peek(), i);
            Assert.assertEquals((int) stack.pop(), i);
            Assert.assertEquals(stack.size(), i);
        }
        Assert.assertEquals(stack.size(), 0);
        for (int i = 0; i < 20; i++) {
            Assert.assertEquals(stack.size(), i);
            stack.push(i);
            Assert.assertEquals(stack.size(), i + 1);
        }
        Assert.assertEquals(stack.size(), 20);
    }
}