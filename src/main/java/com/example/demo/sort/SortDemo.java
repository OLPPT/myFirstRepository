package com.example.demo.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
     * 改进的冒泡排序，可以减少交换次数
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
     * 用一个变量来记录最后交换的位置，那么这之前的序列是已经排序好了的
     * 然后在下一次交换的时候就可以到这个位置停止，可以减少
     * 不必要的无效循环
     * @param arr
     */
    public static void bubbleSortBest(int[] arr){
        if (arr == null || arr.length == 0)
            return ;
        int lastSwap,lastSwapTemp = 0;
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
     * 和冒泡相比，减少了交换的次数，每次只把最小的与最前面的交换
     * 时间复杂度O(n^2)
     * @param arr
     */
    public static void selectSort(int[] arr){
        if (arr == null || arr.length ==0)
            return ;
        int minIndex;
        for (int i = 0; i < arr.length-1; i++){
            minIndex = i;
            for (int j = i+1; j < arr.length; j++){//不用和自己比较 j = i+1
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
                /**
                 * 由于前一步已经把最大的数换走了，
                 * 所以要是再是常规交换一次就又换回来了，
                 * 所以就和自身交换一次，也可以选择不交换
                 */
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

    /**
     * 快速排序的左右指针法，冒泡的改进
     * 时间复杂度，选择的基准元素为'最大或最小时',是最坏的情况,此时时间复杂度为O(n^2)
     *            选择的基准元素为'中值',是最好的情况,时间复杂度为O(nlog2n))
     * @param arr
     * @param _left
     * @param _right
     */
    public static void quickSort(int[] arr,int _left,int _right){
        int left = _left,right = _right,key;
        if (left <= right){
            key = arr[left]; //让左边第一个元素为基准元素
            while (left != right){ //l r指针分别从左右开始扫描
                while (right > left && arr[right] >=key) //r指针从右边扫描，找比key小的值，
                    right--;
                arr[left] = arr[right];    //进行交换
                while (right > left && arr[left] <=key) //l指针从左往右扫描，找比key大的值
                    left++;
                arr[right] = arr[left];    //进行交换
            }
            arr[left] = key;   //基准元素放到该放的地方
            //以基准元素左右两边的分段区域进行递归操作
            quickSort(arr,_left,left-1);
            quickSort(arr,right+1,_right);
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
    public static void heapSort(int[] arr){
        for (int i = (arr.length >>> 1) - 1; i >=0; i--){

        }
    }

    /**
     * 上浮index处的元素
     * @param arr
     * @param index
     */
    public static void shiftUp(int[] arr, int index){
        int max = index;
        int left = index * 2 + 1;
        int right = left + 1;
        if (index < arr.length << 1){
            if (left <=arr.length-1 && arr[left] > arr[max]){
                max = left;
            }
            if (right <=arr.length-1 && arr[right] > arr[max]){
                max = right;
            }
            if (max != index){
                swap(arr,index,max);
            }
        }
    }
    public static void createHeap(int[] arr){
        for (int i = (arr.length -2)/2;i >= 0;i--){
            shiftUp(arr,i);
        }
    }
    public static void removeDup(List<String> list){
        HashSet<String> hashSet = new HashSet<>(list);
        list.clear();
        list.addAll(hashSet);
        System.out.println(list);
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{9,3,4,6,7,1};
//        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9,10};
          int[] arr = new int[]{2,0,4,9,3,6,8,7,1,5};
//          quickSort(arr,0,arr.length-1);
        createHeap(arr);
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("234");
        list.add("124");
        removeDup(list);
    }
}
