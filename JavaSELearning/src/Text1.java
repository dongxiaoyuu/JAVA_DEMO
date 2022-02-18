/**
 * Created with IntelliJ IDEA
 * Description:some texts
 * User:dxy
 * Date:2022-02-07
 * Time:17:51
 */
import java.util.Scanner;

public class Text1 {
    //返回二进制的1的个数
    //优化
    public static void main(String[] args) {
        int n=7;
        int count =0;
        while(n!=0){
            if((n&1)!=0){
                count++;
            }
            n>>>=1;
        }
        System.out.println(count);
    }
    /*public static void main(String[] args) {
        int n=10;
        int count=0;
        for(int i=0;i<32;i++){
            if(((n>>i)&1)!=0){
                count++;
            }
        }
        System.out.println(count);
    }*/
    //水仙花数
    public static void main5(String[] args) {
        for(int i=0;i<999999;i++){
            int tmp=i;
            int count =0;//计算当前的数字i有多少位
            while(tmp!=0){
                count++;
                tmp=tmp/10;

            }
            tmp=i;//求tmp的每一位是多少
            int sum=0;
            while (tmp!=0){
                sum+=Math.pow(tmp%10,count);
                tmp/=10;
            }
            if(sum==i){
                System.out.println(i);
            }
        }
    }
    //最大公约数--辗转相除法
    public static void main4(String[] args) {
        int a=24;
        int b=18;
        int c=a%b;
        while (c!=0){
            a=b;
            b=c;
            c=a%b;
        }
        System.out.println(b);
    }
//    输出素数
    public static void main3(String[] args) {
        //int n=10;
        for (int n=1;n<101;n++) {
            int i = 2;
            for (; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    System.out.println(n+"不是素数");
                    break;
                }
            }
            if (i > Math.sqrt(n)) {
                System.out.println(n + "是素数");
            }
        }
    }
/*    编写代码模拟三次密码输入的场景。
    最多能输入三次密码，密码正确，提示“登录成功”,密码错误，
    可以重新输 入，最多输入三次。三次均错，则提示退出程序*/
    public static void main2(String[] args) {
        System.out.println("请输入密码");
        int passwd=666;
        int flat=0;
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()) {
            int n= scanner.nextInt();
            if(n==passwd){
                System.out.println("密码正确！");
                break;
            }else{
                flat++;
                if(flat==3){
                    System.out.println("已关机");
                    break;
                }
                System.out.println("密码错误，请重新输入");

            }

        }

    }


    //输出X
    public static void main1(String[] args) {
        Scanner scanner =new Scanner(System.in);

        while (scanner.hasNext()){
            int n= scanner.nextInt();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j||i==(n-j-1)) {
                        sb.append("*");
                    }
                    else{
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}
