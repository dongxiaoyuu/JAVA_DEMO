package Projection_library.operation;
import Projection_library.book.Book;
import Projection_library.book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-02-26
 * Time:15:57
 */
public class DelOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("delete");
        Scanner sc =new Scanner(System.in);
        System.out.println("输入要删除的书籍");
        String name=sc.nextLine();
        int currentSize=bookList.getUsedSize();
        int index=-1;
        for (int i = 0; i < currentSize; i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                index=i;
                break;
            }
        }
        //没有这本书
        if(index==-1){
            System.out.println("no book!");
        }
        int currSize=bookList.getUsedSize();
        for (int i = index; i < currSize-1; i++) {
           // bookList[i]=bookList[i+1];
            Book book=bookList.getBook(i+1);
            bookList.setBookList(i,book);
        }
        bookList.setUsedSize(currSize-1);
    }
}
