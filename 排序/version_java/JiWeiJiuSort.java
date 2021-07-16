package 排序.version_java;

import java.util.Arrays;

public class JiWeiJiuSort {
    
    public static void cockTailSort(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            // 有序标记，每一轮的初始是true
            boolean isStored = true;
            for (int j = i; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isStored = false;
                }
            }
            if (isStored) {
                break;
            }
            isStored = true;
            for (int j = array.length-i-1; j > i; j--) {
                if (array[j] < array[j-1]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    isStored = false;
                }
            }
            if (isStored) {
                break;
            }
        }   
    }

    /**
     * 鸡尾酒排序

    一次大的遍历
    - 从左到右一遍
    - 从右到左一遍
        遍历第一次
        6, 7, 8, 1, -1
        ----------------从左到右，从小到大依次交换
        6, 7, 8, -1, 1
        ----------------从右到左，从小到大一次交换
        6, 7, -1, 8, 1
        ----------------
        -1, 6, 7, 8, 1
        ----------------
        遍历第二次       从左到右，从小到大依次交换
        -1, 6, 7, 1, 8
        ----------------从右到左，从小到大一次交换
        -1, 6, 1, 7, 8
        ----------------
        -1, 1, 6, 7, 8
        遍历第三次
        is_sorted = True
        结束
     */
    public static void main(String[] aStrings) {
        int[] arr = new int[] {54, 26, 44, 17, 77, 26, 31, 93, 55};
        cockTailSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
