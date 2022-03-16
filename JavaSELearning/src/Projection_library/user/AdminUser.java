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
public class AdminUser extends User{
    public AdminUser(String name) {
        super(name);
        //存储操作
        this.iOperations=new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()

        };
    }
    public int menu(){
        System.out.println("===============admin=================");
        System.out.println("hello "+this.name+" welcome");
        System.out.println("1.查找");
        System.out.println("2.新增");
        System.out.println("3.删除");
        System.out.println("4.显示");
        System.out.println("0.退出");
        System.out.println("======================================");
        System.out.println("please input operation:");
        Scanner scan =new Scanner(System.in);
        int choice=scan.nextInt();
        return choice;

    }


}
