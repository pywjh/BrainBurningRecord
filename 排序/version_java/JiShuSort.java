package 排序.version_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计数排序
 */
public class JiShuSort {

    public static List<Integer> countSort(int[] array) {
        /**
         * 计数排序（不稳定）
            4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10
            ------------------------------------------找到最大值 --> 10
            创建一个长度为10 + 1的数组
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
            ------------------------------------------
            遍历原数组
            将原数组的元素值作为新数组的索引，逐个+1
            ------------------------------------------
            比如，第一个元素是4
            新数组索引4的值+1
            0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0
            ------------------------------------------
            第二个元素是4
            0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0
            ------------------------------------------
            第三个元素是6
            0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0
            ------------------------------------------
            。。。。
            ------------------------------------------
            最终
            1, 1, 1, 1, 2, 2, 2, 1, 1, 0, 1
            ------------------------------------------
            再遍历这个新数组
            将新数组的索引作为值，值作为数量，输出
            ------------------------------------------
            比如，索引0，数量是1
            所以第一个元素是0
            0
            ------------------------------------------
            索引1，数量是1
            0, 1
            ------------------------------------------
            索引2，数量是1
            0, 1, 2
            ------------------------------------------
            索引3，数量是1
            0, 1, 2, 3
            ------------------------------------------
            索引4，数量是2
            0, 1, 2, 3, 4, 4
            ------------------------------------------
            索引5，数量是2
            0, 1, 2, 3, 4, 4, 5, 5
            ------------------------------------------
            。。。。。。。。。。
            ------------------------------------------
            0, 1, 2, 3, 4, 4, 5, 5, 6, 6, 7, 8, 10
         */
        // 得到数列的最大值
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        // 根据数列最大值确定统计数组的长度
        int[] countArray = new int[maxValue+1];
        // 遍历数列，填充统计数组
        for (int i: array) {
            countArray[i] += 1;
        }
        // 遍历统计数组，输出结果
        ArrayList<Integer> sortArray = new ArrayList<>();
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortArray.add(i);
            }
        }
         return sortArray;
    }

    public static int[] countSortV2(int[] array) {
        int maxValue = array[0];
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        int d = maxValue - minValue;
        // 创建统计数组并统计对应元素个数
        int[] countArray = new int[d+1];
        for (int i: array) {
            countArray[i - minValue] += 1;
        }
        // 统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        // 倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i]-minValue]-1] = array[i];
            countArray[array[i] - minValue] -= 1;
        }
        return sortedArray;
    }


    public static void main(String[] array) {
        int[] array1 = {4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] array2 = {95, 94, 91, 110, 90, 99, 93, 91, 92};
        System.out.println(countSort(array1));
        System.out.println(Arrays.toString(countSortV2(array2)));
    }
}