import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:2.28 homework
 * User:dxy
 * Date:2022-03-07
 * Time:11:30
 */

//实现一个简单的控制台版用户登陆程序,
// 程序启动提示用户输入用户名密码.
// 如果用户名密码出错, 使用自定义异常的方式来处理

public class Text4  {
    private static String name="admin";
    private static int sysPasswd=12345;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.nextLine();
        System.out.println("请输入密码：");
        int passwd=sc.nextInt();
        try{
            if(!username.equals(name)){
                throw new UsernameError("用户名错误");
            }
        }catch (UsernameError e) {
            e.printStackTrace();
        }
        try {
            if(sysPasswd!=passwd){
                throw new PasswdError("密码错误");
            }
            System.out.println("登录成功");
        }catch (PasswdError e){
            e.printStackTrace();
        }

    }


}

class UsernameError extends Exception{
    public UsernameError(String message){
        super(message);
    }
}
class PasswdError extends Exception {
    public PasswdError(String message) {
        super(message);
    }
}
