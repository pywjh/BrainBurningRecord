package 排序.version_java;

import java.util.Arrays;

public class ChaRuSort {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int j = i - 1;
            //从右向左比较元素的同时，进行元素复制
            for (; (j >= 0) && (insertValue < array[j]); j--) {
                array[j + 1] = array[j];
            }
            //insertValue的值插入适当位置
            array[j + 1] = insertValue;
        }
    }

    /**
     * 插入排序

        索引1开始遍历
        2, 6, 5, 4, 3, 1
        ------------------ 索引位与前一位相比 6 > 2 不操作
        2, 6, 5, 4, 3, 1
        遍历到索引2
        ------------------ 5 < 6  
        2, 6, , 4, 3, 1
                5
        ------------------ 将6右移
        2, , 6, 4, 3, 1
                5   
        ------------------ 5 > 2 不移动，将5填入6的位置
        2, 5, 6, 4, 3, 1
        ------------------
        遍历到索引3
        2, 5, 6, , 3, 1
                    4
        ------------------ 4 < 6 将6右移
        2, 5, , 6, 3, 1
                4
        ------------------ 4 < 5 将5右移
        2, , 5, 6, 3, 1
                4
        ------------------ 4 > 2 不移动，将4填入5的位置
        2, 4, 5, 6, 3, 1
        遍历到索引4.......
        2, 3, 4, 5, 6, 1
        ------------------
        遍历到索引5.......
        1, 2, 3, 4, 5, 6
     * @param args
     */
    public static void main(String[] args) {
        int[] array = { 12, 1, 3, 46, 5, 0, -3, 12, 35, 16 };
        insertSort(array);
        // [-3, 0, 1, 3, 5, 12, 12, 16, 35, 46]
        System.out.println(Arrays.toString(array));
    }
}