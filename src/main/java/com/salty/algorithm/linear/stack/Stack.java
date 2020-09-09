package com.salty.algorithm.linear.stack;

interface Stack<T> {
    /**
     * 压栈
     */
    void push(T item);
    //弹栈
    T pop();
    //是否为空
    boolean isEmpty();
    //栈中数据的数量
    int size();
    //返回栈中最近添加的元素而不删除它
    T peek();
}
