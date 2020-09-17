package com.salty.algorithm.linear.binarysearch;

/**
 * @author ryan
 * @since 2020/09/17
 */
public class BinarySearch {

    public static int search(int[] arr, int n) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (arr[mid] == n) {
                return mid;
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
        int[] arr = {1, 4, 6, 7, 8, 12, 15, 35};
        System.out.println(search(arr, 1));
        System.out.println(search(arr, 5));
        System.out.println(search(arr, 8));
        System.out.println(search(arr, 15));
    }
}
