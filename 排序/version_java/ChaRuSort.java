package 排序.version_java;

import java.util.Arrays;

public class ChaRuSort {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int j = i - 1;
            //从右向左比较元素的同时，进行元素复制
            for ( ; j >= 0 ; j--) {
                if (insertValue < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            //insertValue的值插入适当位置
            array[j + 1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] array = { 12, 1, 3, 46, 5, 0, -3, 12, 35, 16 };
        insertSort(array);
        // [-3, 0, 1, 3, 5, 12, 12, 16, 35, 46]
        System.out.println(Arrays.toString(array));
    }
}