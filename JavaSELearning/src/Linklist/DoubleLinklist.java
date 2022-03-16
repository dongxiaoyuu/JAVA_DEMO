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

    public int mySize(){
        int size=0;
        ListNode cur=this.head;
        while (cur!=null) {
            size++;
            cur=cur.next;
        }
        return size;
    }
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
    //TODO按点插入
    public void addIndex(int index,int data){

        ListNode cur=this.head;
        ListNode node=new ListNode(data);
        while (index!=0){
            cur=cur.next;
            index--;
        }
        node.next=cur;


    }

    //删除key
    public void remove(int key){
        ListNode cur=this.head;
       while (cur!=null){
           if(cur.val==key){
               if(cur==head){
                   head=head.next;
                   if(head!=null) {//判断是不是只有一个节点
                       head.prev = null;
                   }
               }else{
                   cur.prev.next=cur.next;
                   if(cur.next!=null) {
                       cur.next.prev = cur.prev;
                   }else{
                       last=last.prev;
                   }
               }
               return;//删除结束
           }else{
               cur=cur.next;

           }
       }
    }
    //删除所有key
    public void removeAll(int key){
        ListNode cur=this.head;
        while (cur!=null){
            if(cur.val==key){
                if(cur==head){
                    head=head.next;
                    if(head!=null) {//判断是不是只有一个节点
                        head.prev = null;
                    }
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null) {
                        cur.next.prev = cur.prev;
                    }else{
                        last=last.prev;
                    }
                }

            }else{
                cur=cur.next;

            }
        }
    }
    //clear all
    public void clear(){
        ListNode cur=head;
        while (cur!=null){
            ListNode curNext=cur.next;
            cur.prev=null;
            cur.next=null;
            cur=curNext;
        }
        head=null;
        last=null;
    }

    public static void main(String[] args) {
        DoubleLinklist mylink=new DoubleLinklist();
        mylink.addFirst(1);
        mylink.addLast(2);
        mylink.addLast(3);
        mylink.display();

    }
}
