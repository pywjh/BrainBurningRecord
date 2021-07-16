package version_java;

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

    public static void main(String[] aStrings) {
        int[] arr = new int[] {54, 26, 44, 17, 77, 26, 31, 93, 55};
        bubbleSort(arr);
        // [17, 26, 26, 31, 44, 54, 55, 77, 93]
        System.out.println(Arrays.toString(arr));
    }
}