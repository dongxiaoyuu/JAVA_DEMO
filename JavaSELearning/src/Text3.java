/**
 * Created with IntelliJ IDEA
 * Description:2.20 homework
 * User:dxy
 * Date:2022-02-20
 * Time:10:17
 */
import java.util.Arrays;
public class Text3 {
    static boolean Paddy;
    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main(String[] args) {
        //System.out.println(Paddy);
        System.out.println("cnt ="+ cnt);

       /* int[]arr={4,3,10,7,8,0,45,120};
        bubble(arr);*/


        /*int ret;
        ret=isOrder(arr);
        if(ret==-1){
            System.out.println("数组无序");
        }else {
            System.out.println("数组有序");
        }*/
        /*ret=binarySearch(12,arr);
        System.out.println("arr["+ret+"]");*/
        /*System.out.println("arr:"+Arrays.toString(arr));
        myCopyOf(arr);*/
        //myToString(arr);
    }
    static{
        cnt /=3;
    };
    //判断数组是否有序
    public static int isOrder(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return -1;

            }
        }
        return 0;
    }
    //二分查找
    public static int binarySearch(int k,int[] arr) {
        int left=0;
        int right=arr.length-1;
        int middle=0;
        if(k<arr[left]||k>arr[right]||left>right){
            return -1;
        }
        while (left<=right){
            middle=(left+right)/2;
            if(arr[middle]==k){
                return middle;
            }else if(arr[middle]<k){
                left=middle+1;
            }else {
                right=middle-1;
            }

        }
        return -1;

    }
    //实现copyOf
    public static void myCopyOf(int[]arr) {
        int[] newArr=Arrays.copyOf(arr,arr.length);
        System.out.println("newArr:"+Arrays.toString(newArr));
    }
    //实现一个toString
    public static void myToString(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    public static void bubble(int[]arr) {
        System.out.println("before:"+Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        System.out.println("after:"+Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        int[] arr={1,4,8,4,3,0};
        System.out.println("before:"+Arrays.toString(arr));
        bubble(arr);
        System.out.println("after:"+Arrays.toString(arr));
    }
}
