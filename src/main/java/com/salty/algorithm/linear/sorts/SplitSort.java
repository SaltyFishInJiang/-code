package com.salty.algorithm.linear.sorts;

/**
 * 混杂 数字 和 字母 的数组
 * 1. 数字在地位, 字母在高位
 * 2. 数字在低位, 小写在中位, 大写在高位
 * @author ryan
 * @since 2020/09/17
 */
public class SplitSort {

    public static char[] sort1(char[] cs) {
        if (cs == null || cs.length <= 1) {
            return cs;
        }
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            while (cs[i] >= '0' && cs[i] <= '9') {
                i++;
            }
            while (cs[j] >= 'a' && cs[j] <= 'z') {
                j--;
            }
            if (i < j) {
                swap(cs, i, j);
            }
        }

        return cs;
    }

    public static void swap(char[] arr, int i, int j) {
        char f = arr[i];
        arr[i] = arr[j];
        arr[j] = f;
    }

    public static void main(String[] args) {
        System.out.println(sort1("12gf457nx0ds".toCharArray()));
    }
}
