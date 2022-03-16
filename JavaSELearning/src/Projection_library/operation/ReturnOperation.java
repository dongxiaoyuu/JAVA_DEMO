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
public class ReturnOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("return");
        Scanner sc =new Scanner(System.in);
        System.out.println("输入要归还的书籍");
        String name=sc.nextLine();
        int currentSize=bookList.getUsedSize();

        for (int i = 0; i < currentSize; i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(false);
                System.out.println("success!!信息如下：");
                System.out.println(book);
                return;
            }
        }
        //没有这本书
        System.out.println("no book");
    }
}
