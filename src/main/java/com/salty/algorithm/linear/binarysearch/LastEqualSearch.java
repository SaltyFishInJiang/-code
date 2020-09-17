package com.salty.algorithm.linear.binarysearch;

/**
 * 最后一个等于特定值
 * @author ryan
 * @since 2020/09/17
 */
public class LastEqualSearch {

    public static int search(int[] arr, int n) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (arr[mid] == n) {
                if (mid == arr.length - 1 || arr[mid + 1] != n) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            }
            if (arr[mid] > n) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 6, 7, 8, 8, 12, 15, 15, 35};
        System.out.println(search(arr, 1));
        System.out.println(search(arr, 5));
        System.out.println(search(arr, 8));
        System.out.println(search(arr, 15));
    }
}
