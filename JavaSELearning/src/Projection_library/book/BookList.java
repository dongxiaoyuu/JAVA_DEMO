package Projection_library.book;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-02-25
 * Time:21:36
 */
public class BookList {
    public Book[] bookList=new Book[10];
    private int usedSize;//书架上有几本书
    public BookList(){
        this.bookList[0]=new Book("孤门","coco",18,"小说");
        this.bookList[1]=new Book("孤门2","coco",19,"小说");
        this.bookList[2]=new Book("孤门3","coco",20,"小说");
        this.usedSize=3;

    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

  //把书放到pos
    public void setBookList(int pos,Book book) {
        bookList[pos]=book;
    }
    //获取pos的书
    public Book getBook(int pos){
        return bookList[pos];
    }
}
