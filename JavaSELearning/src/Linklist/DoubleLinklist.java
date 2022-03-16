package Linklist;

import org.omg.CORBA.PUBLIC_MEMBER;

import static sun.plugin2.os.windows.OSVERSIONINFOA.size;

/**
 * Created with IntelliJ IDEA
 * Description:双向链表
 * User:dxy
 * Date:2022-03-15
 * Time:21:28
 */
class ListNode{
    public int val;
    public ListNode next;
    public ListNode prev;
    public ListNode(int val){
        this.val=val;
    }
}
public class DoubleLinklist {
    public ListNode head;
    public ListNode last;


    public boolean contains(int key){
        ListNode cur=this.head;
        while (cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    public void display(){
        ListNode cur=this.head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
    //头插
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
            last=node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
            last=node;
        }else {
            last.next=node;
            node.prev=last;
            last=node;
        }
    }
    //
    public void addIndex(int index,int data){

        ListNode cur=this.head;
        ListNode node=new ListNode(data);
        while (index!=0){
            cur=cur.next;
            index--;
        }
        node.next=cur;


    }
    public static void main(String[] args) {
        DoubleLinklist mylink=new DoubleLinklist();
        mylink.addFirst(1);
        mylink.addFirst(2);
        mylink.display();
    }
}
