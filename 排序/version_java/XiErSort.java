package 排序.version_java;

import java.util.Arrays;

public class XiErSort {
    public static void shellSort(int[] array) {
        //希尔排序的增量
        int d = array.length;

        while (d > 1) {
            //使用希尔增量的方式，即每次折半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; (j >= 0) && (array[j] > temp); j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 3, 9, 12, 6, 1, 7, 2, 4, 11 };
        // 这个例子希尔排序没有排上作用，反倒消耗了多余的性能
        // int[] array = { 2, 1, 5, 3, 7, 6, 9, 8 };  
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}