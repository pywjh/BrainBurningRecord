package 排序.version_java;

import java.util.Arrays;

public class MaoPaoSort {

    public static void bubbleSort(int[] array) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    // 把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序

    遍历，索引i值与索引i+1值相比，大于就交换

        第一次遍历
        6, 7, 8, 1, -1
        ------------------一次大小交换
        6, 7, 8, -1, 1
        ------------------第二次遍历
        6, 7, -1, 8, 1
        ------------------
        6, 7, -1, 1, 8
        ------------------第三次遍历
        6, -1, 7, 1, 8
        ------------------
        6, -1, 1, 7, 8
        ------------------第四次遍历
        -1, 6, 1, 7, 8
        ------------------
        -1, 1, 6, 7, 8
        is_sorted = True 
        结束
     */
    public static void main(String[] aStrings) {
        int[] arr = new int[] {54, 26, 44, 17, 77, 26, 31, 93, 55};
        bubbleSort(arr);
        // [17, 26, 26, 31, 44, 54, 55, 77, 93]
        System.out.println(Arrays.toString(arr));
    }
}