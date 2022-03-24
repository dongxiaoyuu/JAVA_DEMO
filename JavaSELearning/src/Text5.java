import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Description:3-16homework
 * User:dxy
 * Date:2022-03-17
 * Time:20:24
 */
public class Text5 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for (int i = 0; i < pushA.length; i++) {

            if (stack.empty()) {
                stack.push(pushA[i]);

            }
            while (!stack.empty()) {
                if (stack.peek() == popA[j]) {
                    stack.pop();
                    j++;
                } else break;

            }

        }
    return stack.empty();

    }


    private boolean isNumber(String str){
        return !("+".equals(str)||"-".equals(str)||"*".equals(str)||"/".equals(str));
    }
    public int evalRPN(String []tokens){
        Stack<Integer> stack=new Stack<>();
        int n=tokens.length;
        for (int i = 0; i < n; i++) {
            String token=tokens[i];

            if(isNumber(token)){
                stack.push(Integer.parseInt(token));
            }else{
                int num1=stack.pop();
                int num2=stack.pop();
                switch (token){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case"-":
                        stack.push(num1-num2);
                        break;
                    case"*":
                        stack.push(num1*num2);
                        break;
                    case"/":
                        stack.push(num1/num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }
}
