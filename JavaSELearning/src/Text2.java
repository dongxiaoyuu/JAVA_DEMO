import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA
 * Description:2.17~2.18 homework
 * User:dxy
 * Date:2022-02-19
 * Time:19:31
 */
public class Text2 {

    public static void main(String[] args) {

        int []arr={1,2,3,4,5,6};
        printArray(arr);


       /* int ret;
        ret=arr_sum(arr);
        System.out.println(ret);*/
        /*double ret;
        ret=avg(arr);
        System.out.println(ret);*/

        /*int ret;
        ret=sum_sum2(5);
        System.out.println(ret);*/
        //sum_sum(3);
        //fac_n(5);
        //single();
    }
    //打印数组
    public static void printArray(int[]arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    //求数组元素之和
    public static int arr_sum(int[]arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
    //求数组平均值
    public static double avg(int []arr) {
        double sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        double average=sum/arr.length;
        return average;
    }
    //求阶乘（递归）
    public static int sum_sum2(int n) {

        if(n==1||n==0) {
            return 1;
        } else {
            return n*sum_sum2(n-1);
        }
    }
    //求阶乘和
    public static void sum_sum(int n) {
        int total=1;
        int sum=0;

            for (int i = 1; i <= n; i++) {
                total *= i;
                sum+=total;
            }


        System.out.println(n+"的阶乘是:"+total+" "+n+"的阶乘和是："+sum);
    }
    //斐波那契第n项
    public static void fac_n(int n) {
        int a=1;
        int b=1;
        int c=1;
        for (int i = 3; i <=n ; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        System.out.println(c);
    }
    //找单身狗
    public static void single() {
        int []arr={1,7,7,0,4,888,5,0,5,4,1};

        for(int i=0;i<arr.length;i++){
            boolean flag=false;
            for(int j=0;j<arr.length;j++) {
                if(i==j){
                    continue;
                }
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }

            }
            if (flag != true) {
                System.out.println(arr[i]);
            }
        }
    }


}
