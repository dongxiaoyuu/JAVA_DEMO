package Projection_library.user;

import Projection_library.book.Book;
import Projection_library.book.BookList;
import Projection_library.operation.IOperation;
import jdk.nashorn.internal.ir.SplitReturn;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-03-02
 * Time:11:59
 */
public abstract class User {
    protected String name;
    protected  IOperation[] iOperations;
    public User(String name){
        this.name=name;
    }
    public abstract int menu();
    public void doOperation(int choice, BookList bookList){

        this.iOperations[choice].work(bookList);
    }

}
