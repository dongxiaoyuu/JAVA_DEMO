package arrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:杨辉三角练习
 * User:dxy
 * Date:2022-03-12
 * Time:11:32
 */
public class Text5_Yang {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ret=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        ret.add(list);//第一行已经在了
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow=new ArrayList<>();
            curRow.add(1);
            //j<i
            for (int j = 1; j < i; j++) {
                //获取下一行
                List<Integer> prevRow=ret.get(i-1);
                int val=prevRow.get(j)+prevRow.get(j-1);
                curRow.add(val);
            }
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
