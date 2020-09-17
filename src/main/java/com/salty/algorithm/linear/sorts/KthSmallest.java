package com.salty.algorithm.linear.sorts;

/**
 * 第 k 小的值
 * @author ryan
 * @since 2020/09/16
 */
public class KthSmallest {

    public static int execute(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        do {
            int mid = quickSort(arr, i, j);
            if (mid == k - 1) {
                return arr[mid];
            }
            if (mid > k - 1) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        } while (true);
    }

    public static int quickSort(int[] arr, int p, int l) {
        int i = p, j = p;
        while (j <= l) {
            if (arr[j] < arr[l]) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr, l, i);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int f = arr[i];
        arr[i] = arr[j];
        arr[j] = f;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 45, 4, 3, 65, 34, 54, 23};
        int res = execute(arr, 6);
        System.out.println(res);
    }
}
