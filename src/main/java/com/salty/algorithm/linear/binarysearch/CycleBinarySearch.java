package com.salty.algorithm.linear.binarysearch;

/**
 * @author ryan
 * @since 2020/09/18
 */
public class CycleBinarySearch {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int mVal = nums[mid];
            if (mVal == target) {
                return mid;
            }
            if (nums[r] == target) {
                return r;
            }
            if (nums[l] == target) {
                return l;
            }
            if (nums[l] > nums[r]) {
                if (mVal > nums[l]) {
                    if (mVal < target || nums[r] > target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    if (mVal > target || nums[r] < target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            } else {
                if (mVal < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 15, 35, 1, 4, 6, 7, 8};
        System.out.println(search(arr, 1));
        System.out.println(search(arr, 5));
        System.out.println(search(arr, 8));
        System.out.println(search(arr, 15));
    }
}
