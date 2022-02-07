/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-01-24
 * Time:10:59
 */
import java.util.Scanner;
public class Hello {
    // /3 and /5
    public static void main(String[] args) {
        for(int i=0;i<=100;i++){
            if(i%3==0 && i%5==0){
                System.out.println(i);
            }
        }
    }
    //求阶乘与阶乘和
    public static void main2(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n =scanner.nextInt();
        int ret =1;
        int i=1;
        int sum=0;
        while(i<=n){
            ret *=i;
            i++;
            sum+=ret;
        }
        System.out.println("阶乘："+ret);
        System.out.println("阶乘和："+sum);

    }
    //hello world
    public static void main1(String[] args) {
        System.out.println("hello world!");
    }
}
