package MySort;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Description:冒泡、插入、归并是稳定的排序
 * User:dxy
 * Date:2022-03-26
 * Time:10:14
 */
public class Sort {


    //插入排序--O(n)
    public static void inserSort(int arr[]) {


        for(int i=0;i< arr.length;i++){
            int tmp=arr[i];
            int j = i-1;
            for ( ; j >=0 ; j--) {
                if(arr[j]>tmp){
                    arr[j+1]=arr[j];
                }else {
                    arr[j+1]=tmp;
                    break;
                }
            }
            arr[j+1]=tmp;
        }


    }

    //希尔排序
    public static void shell(int arr[],int gap){
        for(int i=gap;i< arr.length;i++){
            int tmp=arr[i];
            int j = i-gap;
            for ( ; j >=0 ; j-=gap) {
                if(arr[j]>tmp){
                    arr[j+gap]=arr[j];
                }else {
                    arr[j+gap]=tmp;
                    break;
                }
            }
            arr[j+gap]=tmp;
        }
    }
    public static void shellSort(int []arr){
        int gap=arr.length;
        while (gap>1){
            gap/=2;
            shell(arr,gap);
        }
        shell(arr,1);
    }

    //选择排序--O(n^2)
    public static void SelectSort(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex=j;
                }
            }
            swap(arr,minIndex,i);
        }

    }
    public static void swap(int []arr,int a,int b){
        int tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;

    }

    //堆排序--n*logn
    public static void createHeap(int []arr){
        for (int parent = (arr.length-1-1)/2; parent >=0; parent--) {
            shiftDown(arr,parent,arr.length);
        }
    }
    private static void shiftDown(int []arr,int parent,int len){
        int child=(2*parent)+1;
        while (child<len){
            if (child + 1 < len && arr[child] < arr[child+1]) {
                child++;
            }
            if(arr[child]>arr[parent]){
                swap(arr,child,parent);
                parent=child;
                child=2*parent;
            }
            else break;
        }
    }
    public static void heapSort(int[]arr){
        //1.建立大根堆
        createHeap(arr);

        //2.排序
            int end=arr.length-1;
        while (end>0){
            swap(arr,0,end);
            shiftDown(arr,0,end);
            end--;
        }
    }

    //冒泡

    //快速排序
    public static void qucikSort(int []arr){
        quick(arr,0,arr.length-1);
    }
    private static void quick(int arr[],int start,int end ){
        if(end<start) return;
        int pivot=partition(arr,start,end);
        //分治法，递归左右
        quick(arr,start,pivot-1);
        quick(arr,pivot+1,end);
    }
    private static int partition(int[]arr,int left,int right){
        int tmp;
        tmp = arr[left];

        while (left<right) {
            while (left<right&&arr[right] >= tmp) {
                right--;
            }
            //右边找到
            arr[left]=arr[right];

            while (left<right&&arr[left] <= tmp) {
                    left++;
            }
            arr[left]=tmp;

        }
        return left;

    }
    //非递归的快速排序
    public static void quickSort2(int []arr){
        Stack<Integer> stack=new Stack<>();
        int start=0;
        int end=arr.length-1;
        int pivot=partition(arr,start,end);
        if(pivot>start+1){
            stack.push(start);
            stack.push(pivot-1);

        }
        //右边两个元素及以上
        if(pivot<end-1){
            stack.push(pivot+1);
            stack.push(end);
        }
        while (!stack.empty()){
            end=stack.pop();
            start=stack.pop();
            pivot=partition(arr,start,end);
            //左边两个元素及以上
            if(pivot>start+1){
                stack.push(start);
                stack.push(pivot-1);

            }
            //右边两个元素及以上
            if(pivot<end-1){
                stack.push(pivot+1);
                stack.push(end);
            }


        }
    }

    //三数取中法
    private static int threeMid(int[]arr,int left,int right){
        int mid=(left+right)>>>1;
        if(arr[left]<arr[right]){
            if(arr[mid]<arr[left]){
                return left;
            }else if(arr[mid]>arr[right])
                return right;
            else
                return mid;
        }else{
            if(arr[mid]<arr[right]){
                return right;
            }else if(arr[mid]>arr[left])
                return left;
            else
                return mid;
        }
    }

    //归并排序(二路归并)
/*    public static void mergeSort(int[]arr){
        mergeSortFun(arr,0,arr.length-1);
    }
    //递归
    public static void mergeSortFun(int[]arr,int low,int high){
        if(low>=high) return;
        int mid=(low+high)>>>1;
        //分解
        mergeSortFun(arr,low,mid);
        mergeSortFun(arr,mid+1,high);
        //归并
        merge(arr,low,high,mid);
    }*/
    //合并函数
    /*private static void merge(int[]arr,int low,int high,int mid){
        int []tmp=new int[high-low+1];
        int k=0;
        int s1=low;
        int e1=mid;
        int e2=high;
        int s2=mid+1;
        while (s1<e1&&s2<e2){
            if(arr[s1]<=arr[s2]){
                tmp[k++]=arr[s1++];

            }else {
                tmp[k++]=arr[s2++];
            }
        }
        while (s2<=e2){
            tmp[k++]=arr[s2++];
        }
        while ()
    }
*/

    public static void main(String[] args) {
        int arr[]={1,7,8,4,5};
        System.out.println("before:"+ Arrays.toString(arr));
        //inserSort(arr);
        //shellSort(arr);
        //SelectSort(arr);
        //heapSort(arr);
        qucikSort(arr);
       System.out.println("after:"+Arrays.toString(arr));


    }
}
