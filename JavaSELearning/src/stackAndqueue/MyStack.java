package stackAndqueue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-03-16
 * Time:19:46
 */
public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int ret=stack.peek();//获取栈顶元素
        System.out.println(ret);


    }
}
