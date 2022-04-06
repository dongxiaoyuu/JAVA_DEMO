package mapAndSet;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created with IntelliJ IDEA
 * Description:哈希桶
 * User:dxy
 * Date:2022-04-05
 * Time:17:08
 */
public class MyHashBucket {
    static class Node{
        private int val;
        private int key;
        private Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    public int usedSize;//当前存放的数据个数
    public static final double DEFUALT_LOAD_FACTOR=0.75;//默认负载因子
    public Node []arr;

    public MyHashBucket(){
        arr=new Node[8];
    }

    //添加key和val
    public boolean put(int key,int val){
        Node node= new Node(key,val);
        //1.找到位置
        int index=val%arr.length;
        //2.遍历下标的列表
        Node cur=arr[index];
        while (cur!=null){
            if(cur.key==key) {
                cur.val=val;
                return false;
            }
            cur=cur.next;
        }
        //3.遍历完成，没找到，头插
        node.next=arr[index];
        arr[index]=node;
        this.usedSize++;
        //4.判断当前负载因子是否超过默认的负载因子
        if(ladFactor()>DEFUALT_LOAD_FACTOR){
        //5.扩容与重新哈希
            resize();
        }
        return true;
    }
    //重哈希
    private void resize(){
        //1.重申请2倍数组
        Node []tmp=new Node[arr.length*2];
        //2.遍历原数组，并重新哈希
        for (int i = 0; i < arr.length; i++) {
            Node cur=arr[i];
            while (cur!=null){
                int newIndex =cur.key%tmp.length;
                Node curNext=cur.next;
                cur.next=tmp[newIndex];
                tmp[newIndex]=cur;
                cur=curNext;
            }
        }
        arr=tmp;
    }
    private double ladFactor(){
        return this.usedSize*1.0/this.arr.length;
    }
}
