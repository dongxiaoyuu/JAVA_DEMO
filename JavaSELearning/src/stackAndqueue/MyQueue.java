package stackAndqueue;

/**
 * Created with IntelliJ IDEA
 * Description:链表实现队列
 * User:dxy
 * Date:2022-03-19
 * Time:9:26
 */
class Node{
    public int val;
    public Node next;
    public Node(int val ){
        this.val=val;
    }
}
public class MyQueue {
    public Node front;
    public Node rear;

    //入队--尾插法
    public void offer(int val){
        Node node=new Node(val);
        if(this.front==null){
            front=node;
            rear=node;
        }else{
            rear.next=node;
            rear=node;
        }
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return this.front.val;
    }
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int old=front.val;
        front=front.next;
        return old;
    }
    public boolean isEmpty(){
        return true;
    }
}
