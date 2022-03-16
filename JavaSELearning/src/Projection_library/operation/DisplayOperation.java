package Projection_library.operation;
import Projection_library.book.Book;
import Projection_library.book.BookList;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-02-26
 * Time:15:58
 */
public class DisplayOperation implements IOperation{
    public void work(BookList bookList){

        System.out.println("display");
        int currentSize=bookList.getUsedSize();
        for (int c = 0; c < currentSize; c++) {
            Book book=bookList.getBook(c);
            System.out.println(book);

        }
    }
}
