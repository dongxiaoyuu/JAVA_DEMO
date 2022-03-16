package Projection_library.operation;
import Projection_library.book.Book;
import Projection_library.book.BookList;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-02-26
 * Time:15:59
 */
public class ExitOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("exit");
        System.exit(0);
    }
}
