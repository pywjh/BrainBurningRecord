package 排序.version_java;

import java.util.Arrays;

public class XuanZeSort {
    /**
     * 选择排序

    1次遍历，找到索引0-n中最小的，和索引0交换
    2次遍历，找到索引1-n中小的，和索引1交换
    3次遍历，找到索引2-n中小的，和索引2交换

        第0次遍历
        34, 22, 54, 49, 91
        -------------------- [0:] min: 22 索引:1
        0 ！= 1 --> (索引0)34 与 (索引1)22 交换
        22, 34, 54, 49, 91
        --------------------
        第1次遍历
        22, 34, 54, 49, 91
        -------------------- [1:] min: 34 索引:1
        1 == 1 不操作
        --------------------
        第2次遍历
        22, 34, 54, 49, 91 
        -------------------- [2:] min: 49 索引:3
        2 != 3 --> (索引2)54 与 (索引3)49 交换
        22, 34, 49, 54, 91 
        --------------------
        第3次遍历
        22, 34, 49, 54, 91 
        -------------------- [3:] min: 54 索引:3
        3 == 3 不操作 
        --------------------
        第n-1次遍历
        ........
        ....
     */
    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = i + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){ 
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }    
        }
        System.out.print(Arrays.toString(arr));
    }
}
