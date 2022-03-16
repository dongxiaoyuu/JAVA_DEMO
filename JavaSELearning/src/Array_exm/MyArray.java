package Array_exm;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:实现数组
 * User:dxy
 * Date:2022-03-14
 * Time:16:34
 */
public class MyArray {
    //冒泡排序
    public static void Bubble(int []arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j-1]>arr[j]){
                    int tmp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;

                }
            }
        }
    }
    public static void main(String[] args) {
        int []arr={2,4,1,5,7,0};
        //Bubble(arr);
        //System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);//也可以直接用Arrays内置方法
        System.out.println(Arrays.toString(arr));
    }
    public static int binSearch(int[]arr,int num){
        int left=0;
        int right=arr.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if(num<mid){
                right=mid-1;

            }else if(num>mid){
                left=mid+1;
            }else
                return mid;
        }
        return -1;
    }
    public static void main2(String[] args) {
        //二分查找
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println(binSearch(arr,4));

    }
    public static void main1(String[] args) {
        //方法1--引用赋值给引用
        int [] arr={1,2,3,4,5};
        int [] newArr1=arr;
        //System.out.println(Arrays.toString(newArr));
        //方法2--copyOf
        int [] newArr2=Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(newArr2));
        //范围内拷贝
        int [] newArr3=Arrays.copyOfRange(arr,1,3);
        System.out.println(Arrays.toString(newArr3));
    }



}
