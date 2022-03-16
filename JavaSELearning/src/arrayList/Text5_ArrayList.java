package arrayList;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:实现一个ArrAYliST
 * User:dxy
 * Date:2022-03-12
 * Time:9:17
 */
public class Text5_ArrayList {
    public int[] elem;
    public int usedSize;
    public Text5_ArrayList(){
        this.elem=new int[5];
    }

    public void add(int data){
        if(isFull()){
            //扩容
           this.elem=Arrays.copyOf(this.elem,2*elem.length);//2倍扩容
        }
        this.elem[this.usedSize]=data;
        usedSize++;

    }
    public boolean isFull(){
        if(this.usedSize==this.elem.length)
            return true;
        return false;
    }
    //打印
    public void myTostring(){

        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }
    //pos位置新增函数(插入)
    public void add(int pos,int data){
        //不能满的
        //正常插入
        if(pos<0||pos>this.usedSize){
            System.out.println("pos不合法");
            return;
        }
        if(isFull()){
            //扩容
            this.elem=Arrays.copyOf(this.elem,2*elem.length);//2倍扩容
        }
        for (int i = this.usedSize-1; i >=pos ; i--) {
            this.elem[i+1]=this.elem[i];
        }
        this.elem[pos]=data;
        this.usedSize++;
    }
    //是否包含
    public boolean contains(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind)
                return true;
        }
        return false;
    }
    //返回pos位置的元素
    public int get(int pos){
        if(pos<0||pos>this.usedSize){
            System.out.println("pos不合法");
            return -1;
        }
        return this.elem[pos];
    }


/*
    //删除、清空
    public int remove(int key){
        int index=

    }
*/

    public static void main(String[] args) {
        Text5_ArrayList myArr=new Text5_ArrayList();
        myArr.add(1);
        myArr.add(1);
        myArr.add(1);
        myArr.add(1);
        myArr.add(1);
        myArr.add(1);
        myArr.add(2,10);
        myArr.myTostring();
    }
}
