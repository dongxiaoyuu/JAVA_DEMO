package Projection_library.operation;
import Projection_library.book.Book;
import Projection_library.book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-02-26
 * Time:15:50
 */
public class AddOperation implements IOperation{
    public void work(BookList bookList){

        System.out.println("add");
        Scanner sc =new Scanner(System.in);
        System.out.println("输入名字");
        String name=sc.nextLine();
        System.out.println("输入作者");
        String author=sc.nextLine();
        System.out.println("输入类型");
        String type=sc.nextLine();
        System.out.println("输入价格");
        int price=sc.nextInt();
        Book book=new Book(name,author,price,type);
        int currentSize=bookList.getUsedSize();
        bookList.setBookList(currentSize,book);
        bookList.setUsedSize(currentSize+1);//成功放入一本书
        System.out.println("success!");
    }
}
