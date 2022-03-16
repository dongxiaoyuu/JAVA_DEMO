package Projection_library;

import Projection_library.book.BookList;
import Projection_library.user.AdminUser;
import Projection_library.user.NormalUser;
import Projection_library.user.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-02-25
 * Time:21:28
 */
public class Main {
    public static User login(){
        System.out.println("please input name");
        Scanner scan =new Scanner(System.in);
        String name=scan.nextLine();
        System.out.println("please input identification:1->admin 0->normal user");
        int choice=scan.nextInt();
        if(choice==1){
            return new AdminUser(name);
        }else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        BookList  bookList=new BookList();
        //登录并显示菜单
        User user=login();
        while (true) {
            int choice = user.menu();

            user.doOperation(choice, bookList);
        }
    }
}
