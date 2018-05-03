package com.example.demo.sort;

/**
 * Created by OL-PC on 2018/05/02.
 */
public class SortDemo {
    //##################冒泡排序##################################
    /**
     * 冒泡排序：通过相邻元素的比较、交换从而达到排序的目的
     * 如果排好序了，依旧会进行无效的循环
     * O(n^2)
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0)
            return ;
        //轮数
        for (int i = 0; i < arr.length-1; i++){
            for (int j = arr.length-1; j > i;j--){
                if (arr[j-1] > arr[j])
                    swap(arr, j-1, j);
            }
        }
    }

    /**
     * 改进的冒泡排序
     * 排序好之后还是会进行一次无效的循环
     * @param arr
     */
    public static void bubbleSortBetter(int[] arr){
        if (arr == null || arr.length == 0)
            return ;
        boolean isSorted;
        //轮数
        for (int i = 0; i < arr.length-1; i++){
            isSorted = false;
            for (int j = arr.length-1; j > i;j--){
                if (arr[j-1] > arr[j]) {
                    swap(arr, j - 1, j);
                    isSorted = true;
                }
            }
            if (!isSorted)
                break;
        }
    }

    /**
     * 改进版本②，arr[0...i]如果是已排序好的，在轮次的时候也会进行无效的循环（不交换元素）
     * 用一个变量来记录最后交换的位置，然后在下一次交换的时候就可以到这个位置停止，可以减少
     * 不必要的无效循环
     * @param arr
     */
    public static void bubbleSortBest(int[] arr){
        if (arr == null || arr.length == 0)
            return ;
        int lastSwap = 0,lastSwapTemp = 0;
        for (int i = 0; i < arr.length-1; i++){
            lastSwap = lastSwapTemp;
            for (int j = arr.length-1; j > lastSwap; j--){
                if (arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                    lastSwapTemp = j;
                }
            }
            if (lastSwap == lastSwapTemp)
                break;
        }
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //################选择排序################################

    /**
     * 简单的选择排序，拿出一个数，与剩下的比较，选出最小的索引，如果索引不和拿出的数一样，就交换
     * 反复执行arr.length-1轮
     * 时间复杂度O(n^2)
     * @param arr
     */
    public static void selectSort(int[] arr){
        if (arr == null || arr.length ==0)
            return ;
        int minIndex;
        for (int i = 0; i < arr.length-1; i++){
            minIndex = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i)
                swap(arr,minIndex,i);
        }
    }

    /**
     * 二元选择交换，每一轮都选出一个最大和最小的数，放在两端
     * 相比简单选择交换，减半了扫描的轮次数
     * 时间复杂度O(n^2)
     * @param arr
     */
    public static void selectSortBetter(int[] arr){
        if (arr == null || arr.length ==0)
            return ;
        for (int i = 0;i < arr.length/2; i++){
            int minIndex = i;
            int maxIndex = arr.length-i-1;

            for (int j = i; j < arr.length-i; j++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
                if (arr[j] > arr[maxIndex])
                    maxIndex = j;
            }
            if (i != minIndex)
                swap(arr,i,minIndex);
            if (maxIndex == i)
                // 由于前一步已经把最大的数换走了，
                // 所以要是再是常规交换一次就又换回来了，
                // 所以就和自身交换一次，也可以选择不交换
                swap(arr,minIndex,arr.length-i-1);
            else
                swap(arr,maxIndex,arr.length-i-1);

        }
    }
    //#############插入排序########################

    /**
     * 取出一个数，与前面的进行比较，然后满足条件将arr[0...i]往后移,
     * 所以最坏的情况时间复杂度是O(n^2),最好的情况是有序状态，时间复杂度为O(n)
     * @param arr
     */
    public static void insertSort(int[] arr){
        if (arr == null || arr.length ==0)
            return ;
        for (int i = 1;i < arr.length;i++){
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && temp < arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
    static class BinarySearch{
        /**
         * 标准的二分查找
         * @param arr
         * @param key
         * @return
         */
        private static int binarySearch(int[] arr,int key){
            int l = 0,r = arr.length-1;
            while (l <= r){
                int mid = (l + r)/2;
                if (key == arr[mid])
                    return mid;
                else if (key < arr[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            if (r >= arr.length && arr[r] == key)
                return l;
            return -1;
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{9,3,4,6,7,1};
//        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9,10};
          int[] arr = new int[]{1,3,5,6,7,8,9,10};
          BinarySearch.binarySearch(arr,3);
    }
}
