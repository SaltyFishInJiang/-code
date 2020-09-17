package com.salty.algorithm.linear.binarysearch;

/**
 * 最后一个小于等于
 * @author ryan
 * @since 2020/09/17
 */
public class LastLeSearch {

    public static int search(int[] arr, int n) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (arr[mid] <= n) {
                if (mid == arr.length - 1 || arr[mid + 1] > n) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 6, 7, 8, 8, 12, 15, 15, 35};
        System.out.println(search(arr, 0));// -1
        System.out.println(search(arr, 1));// 0
        System.out.println(search(arr, 5)); // 2
        System.out.println(search(arr, 8)); // 6
        System.out.println(search(arr, 15)); // 9
        System.out.println(search(arr, 35)); // 10
        System.out.println(search(arr, 40)); // 10
    }
}
