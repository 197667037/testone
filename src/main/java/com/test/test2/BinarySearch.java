package com.test.test2;

import org.junit.Test;

public class BinarySearch {
    public static int rank(int key, int[] a) { // 数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // 被查找的键要么不存在，要么必然存在于 a[lo..hi] 之中
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(Math.abs(-2147483648));
        System.out.println(1.0 / 0.0);
//        int[] whitelist = {10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98};
//        int[] whitelist = {1,2,4,6,7,10};
//        Arrays.sort(whitelist);
//
////        int key = 50;
//        int key = 3;
//        System.out.println(rank(key, whitelist));

    }

    @Test
    public void test1() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            f = f + g;
            System.out.println(f);
            g = f - g;
            System.out.println(g);
        }
        System.out.println("------------");
    }
}