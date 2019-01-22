package com.test.test2;

import org.junit.Test;

/**
 * @author: liuxl
 * @date: 2018-07-26 11:16
 * @description:
 */
public class Demo1 {

    @Test
    public void test1() {

        int[] array = {5, 8, 2, 3, 1, 9, 7, 4, 6};
        int[] arr = {5, 1, 2, 3, 8, 9, 7, 4, 6};
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

    }
}