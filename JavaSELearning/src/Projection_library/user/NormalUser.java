package Projection_library.user;

import Projection_library.operation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-03-02
 * Time:12:01
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        //存储操作，把操作放到数组里q
        this.iOperations=new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }
    public int menu(){
        System.out.println("===============normal user============");
        System.out.println("hello "+this.name+" welcome");
        System.out.println("1.查找");
        System.out.println("2.借阅");
        System.out.println("3.归还");
        System.out.println("0.退出");
        System.out.println("please input operation:");
        Scanner scan =new Scanner(System.in);
        int choice=scan.nextInt();
        System.out.println("======================================");
        return choice;


    }
}
