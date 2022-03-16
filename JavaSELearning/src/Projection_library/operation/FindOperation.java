package Projection_library.operation;
import Projection_library.book.Book;
import Projection_library.book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-02-26
 * Time:16:00
 */
public class FindOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("find");
        Scanner sc =new Scanner(System.in);
        System.out.println("输入要查找的书籍");
        String name=sc.nextLine();
        int size=bookList.getUsedSize();
        for(int i=0;i<size;i++){
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println("找到了：");
                System.out.println(book);
                return;
            };
        }
        System.out.println("没有这本书");
    }
}

