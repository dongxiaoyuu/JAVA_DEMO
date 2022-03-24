package stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Description:用队列来实现栈
 * User:dxy
 * Date:2022-03-19
 * Time:10:25
 */
public class NewStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    public NewStack(){
        qu1=new LinkedList<>();
        qu2=new LinkedList<>();
    }
    public void push(int x){
        if(!qu1.isEmpty()){
            qu1.offer(x);
        }else if(!qu2.isEmpty()){
            qu2.offer(x);
        }else{
            qu1.offer(x);
        }
    }
    public int pop(){
        if(emp()){
            return -1;
        }

        if(!qu1.isEmpty()){
            int size=qu1.size();
            for (int i = 0; i < size-1; i++) {
                int x=qu1.poll();
                qu2.offer(x);
            }
            return qu1.poll();

        }else {
            int size=qu2.size();
            for (int i = 0; i < size-1; i++) {
                int x=qu2.poll();
                qu1.offer(x);
            }
            return qu2.poll();
        }

    }
    //获取栈顶但不删除
    public int top(){
        if(emp()){
            return -1;
        }
        if(!qu1.isEmpty()){
            int size=qu2.size();
            int x=-1;
            for (int i = 0; i < size; i++) {
                 x=qu1.poll();
                qu2.offer(x);
            }
            return x;

        }else {
            int x=-1;
            int size=qu2.size();
            for (int i = 0; i < size; i++) {
                 x=qu2.poll();
                qu1.offer(x);
            }
            return x;
        }
    }
    public boolean emp(){
        if(qu1.isEmpty()&&qu2.isEmpty()){
            return true;
        }
        return false;
    }


}
