package version_java;

import java.util.Arrays;

public class JiWeiJiuSort {
    public static void JiWeiJiuSort(int[] array) {
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

    public static void main(String[] aStrings) {
        int[] arr = new int[] {54, 26, 44, 17, 77, 26, 31, 93, 55};
        JiWeiJiuSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
