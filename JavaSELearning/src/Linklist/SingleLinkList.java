package Linklist;

/**
 * Created with IntelliJ IDEA
 * Description:自制Linklist
 * User:dxy
 * Date:2022-03-12
 * Time:11:51
 */
class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val=val;
    }
}
public class SingleLinkList {
    public Node head;//头是列表的头，不是节点的头
    public int usedSize;//记录节点当前个数

    public static void main(String[] args) {
        SingleLinkList mylink1=new SingleLinkList();
        mylink1.addLast(1);
        mylink1.addLast(2);
       // mylink1.addLast(3);
       mylink1.addLast(2);
       mylink1.addLast(3);
        mylink1.addLast(4);
        //mylink1.myToString();

        SingleLinkList mylink2=new SingleLinkList();
        mylink2.addLast(7);
        mylink2.addLast(7);
        mylink2.addLast(8);
        // mylink1.addLast(3);
        mylink2.addLast(5);
        mylink2.addLast(6);
        mylink2.addLast(7);

        mylink1.myToString();
        mylink1.removeRepetition();
        mylink1.myToString();


       // System.out.println(mylink1.chkPaliandrome());

    }

    //当手动创建一个单链表
    public void creation(){
        Node node1=new Node(12);
        Node node2=new Node(13);
        Node node3=new Node(14);
        Node node4=new Node(15);
        node1.next=node2;//节点的指向
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;//有环
        this.head=node1;
        this.usedSize=4;

    }
    //输出链表数据
    public void myToString(){
        //while (head.next!=null){ //head.next还是要打印啊,最后一个值要打印

        Node cur=this.head;//为了不丢头，保护Head,让cur动吧
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //重载输出
    public void myToString(Node newhead){
        //while (head.next!=null){ //head.next还是要打印啊,最后一个值要打印

        Node cur=newhead;//为了不丢头，保护Head,让cur动吧
        while (cur!=null){ //TODO
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    //查找Key关键字是否在链表中
    public boolean isExist(int key){
        Node cur=this.head;
        while (cur!=null){
            if(cur.val==key){//引用类型要用.equal
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //得到链表长度
    public int mySize(){
        int size=0;
        Node cur=this.head;
        while (cur!=null) {
            size++;
            cur=cur.next;
        }
        return size;
    }
    //头插法插入
    public void addFirst(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            return;
        }
        node.next=this.head;
        this.head=node;
        this.usedSize++;

    }
    //尾插
    public void addLast(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            return;
        }

        Node cur=this.head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        this.usedSize++;
    }
    //指定插入,先找到节点位置--index指到节点
    private Node searchIndex(int index){
        int count=0;
        Node cur=this.head;
        while (count!=index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    public void addIndex(int index,int data){

        if(index<0||index>this.usedSize){
            throw new RuntimeException("index不合法");
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==usedSize){
            addLast(data);
            return;
        }
        Node node=new Node(data);
        Node cur=searchIndex(index);
        node.next=cur.next;
        cur.next=node;
        this.usedSize++;
    }
    //删除第一次出现的key
    private Node findPrevNode(int key){//找到Key的前一个节点,若不存在返回ｎｕｌｌ，存在返回节点地址

        Node prev=this.head;
        while (prev.next!=null){
            if(prev.next.val==key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }
    public void remove(int key){
        if(this.head==null){
            return;
        }
        if(this.head.val==key) {

                this.head = this.head.next;
                return;

        }
        Node prev=findPrevNode(key);
            if(prev==null){
                throw new RuntimeException("不存在");
            }
            Node del=prev.next;
            prev.next=del.next;
    }
    //删除所有值为Key的节点
    public void removeAllKey(int key){
        if(this.head==null) return;
        if(this.head.val==key){
            this.head=this.head.next;
            this.usedSize--;
        }
        Node pre=this.head;
        Node cur = pre.next;

        while (cur!=null){
            if(cur.val==key){
                pre.next=cur.next;
                cur=pre.next;
                this.usedSize--;
            }else {
                pre=cur;
                cur=cur.next;
            }
        }

    }
    //删除列表中重复的节点
    public void removeRepetition(){
        if(this.head==null){return;}
        Node pre=this.head;
        Node cur=pre.next;
        while (cur!=null) {
            if (pre.val == cur.val) {
                pre.next=cur.next;
                cur=pre.next;
                this.usedSize--;
            }else {
                pre=cur;
                cur = cur.next;
            }
        }
    }
    //清除
    public void clear(){
        Node cur=this.head;
        while (cur!=null){
            Node curNext=cur.next;
            cur.next=null;
            cur=curNext;
        }
        this.head=null;
        this.usedSize=0;
    }
    //逆置一个链表
    public Node reverseList(){
        if(this.head==null){
            return null;
        }
        if(this.head.next == null) {
            return this.head;
        }
        Node cur=head.next;
        head.next=null;

        while (cur!=null){
            Node curNext=cur.next;
            cur.next=head;
            head=cur;
            cur=curNext;

        }
        return head;

    }
    //遍历一遍返回中间的节点
    public Node returnNode(){
        Node fast=this.head;
        Node slow=this.head;

            while (fast != null&&fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;

    }
    //输入一个列表，输出倒数第k个节点,只遍历一遍
    public Node findTheK(int k){
        if(k<=0||k>this.usedSize){
            return null;
        }
        Node fast=this.head;
        Node slow=this.head;
        while (k-1>0){   //走k-1步
            if(fast.next==null){
                return null;
            }
            fast=fast.next;
            k--;
        }
        /*for (int i = 0; i < k; i++) {
            fast=fast.next;
        }*/
        while (fast.next!=null){

            fast=fast.next;
            slow=slow.next;

        }
        return slow;
    }

    //两个有序合并为一个有序列表
    public  static Node mergeLink(Node head1, Node head2){
        Node newNote=new Node(-1);//傀儡节点
        Node tmp=newNote;

        while (head1!=null&&head2!=null){
            if(head1.val<head2.val){
                tmp.next=head1;
                tmp=tmp.next;
                head1=head1.next;
            }else {
                tmp.next=head2;
                tmp=tmp.next;
                head2=head2.next;
            }

        }
        if(head1!=null){
            tmp.next=head1;
        }else
            tmp.next=head2;
        return newNote.next;
    }


    //给定值x,分割列表
    public Node partition(Node pHead ,int x){
        if(pHead==null){
            return null;
        }
        Node bs=null;
        Node be=null;
        Node as=null;
        Node ae=null;
        Node cur=pHead;
        while (cur!=null) {
            if (cur.val < x) {
                if(bs==null){
                    bs=cur;
                    be=cur;
                }
                else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as==null){
                    as=cur;
                    ae=cur;
                }else {
                    ae.next=cur;
                    ae=ae.next;
                }
            }
            cur=cur.next;
        }
        if(bs==null){
            return as;
        }

        be.next=as;
        //检查最后一段是不是有数据，如果有的话那就把最后一个节点的Next值为空，否则会发生死循环。
        if(as!=null){
            ae.next=null;
        }
        return bs;

    }

    //判断列表是否回文--难点：怎么向左走？？
    /*1.找到中间节点
    * 2.后半部分逆置
    * 3.遍历前半与后半，对比*/
    public boolean chkPaliandrome(){
        if(head==null){return true;}
        if(head.next==null){return true;}

        //找中间节点
        Node fast=this.head;
        Node slow=this.head;

        while (fast!=null&&fast.next!=null){//注意这里两个判断
            fast=fast.next.next;
            slow=slow.next;
        }
        //反转
        Node cur=slow.next;
        while (cur!=null) {
            Node curNext = cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        //对比
        while (head!=slow){
            if(head.val!= slow.val){
                return false;
            }
            if(head.next==slow){//如果是偶数个节点就要靠这里判断了
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
    }

    //找出两个列表的交点--如何解决相遇前距离不相等的问题？？
    public static Node getInter(Node head1,Node head2){
        if(head1==null||head2==null){
            return null;
        }
        //pl指长列表
        Node pl=head1;
        Node ps=head2;

        //1.分别求长度
        int lenA=0;
        int lenB=0;
        while (pl!=null){
            lenA++;
            pl=pl.next;
        }
        while (ps!=null){
            lenB++;
            ps=ps.next;
        }
        //2.解决长短不一--重新修改指向，pl永远指最长
        pl=head1;
        ps=head2;

        int len=lenA-lenB;
        if(len<0){
            pl=head2;
            ps=head1;
            len=-len;
        }
        //3.长的走len步
        /*for (int i = 1; i <=len; i++) {
            pl=pl.next;
        }*/
        while (len!=0){
            pl=pl.next;
            len--;
        }

        //4.一人一步，直到相遇,5.是不是不相交

            while (pl != ps) {
                pl = pl.next;
                ps = ps.next;
                if(pl==null&&ps==null) {
                    return null;
                }
            }
            return pl;
    }

    //判断列表是否有环
    public boolean isLoop(){
        if(head==null){return false;}
        if(head.next==null){return false;}

        Node fast=this.head;
        Node slow=this.head;
        while (fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) {
                return true;
            }

        }
        return false;
    }
    //环的入口
    /*设相遇点到入口点距离为X，入口点为L
    * S_slow=L+R-X --slow在一圈内一定会相遇
    * S_fast=L+nR+R-X --设fast走了n圈追到
    * 2(L+R-X)=L+nR+R-X  --slow一次走一步，fast一次两步
    * =》L+R-X==nR
    * =》L=nR-R+X
    * =》L=(n-1)R+X    -->相遇点到入口点的距离=从起点到入口点的距离
    * */
    public Node detectLoop(){
        if(this.head==null){
            return null;
        }
        if(isLoop()==false){
            return null;
        }
        Node fast=this.head;
        Node slow=this.head;

        if(fast==null||fast.next==null){
            return null;
        }
        //1.找到相遇点
        do {
            fast = fast.next.next;
            slow = slow.next;
        }while (fast!=slow);
        //2.fast从头出发与slow相遇
        fast=this.head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;

    }
}
