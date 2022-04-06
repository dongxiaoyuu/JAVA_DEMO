package mapAndSet;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-04-05
 * Time:16:55
 */
public class MyHashMap {
    int []val=new int[100000];
    public MyHashMap() {
        Arrays.fill(val,-1);
    }

    public void put(int key, int value) {
        val[key]=value;
    }

    public int get(int key) {
        return val[key];
    }

    public void remove(int key) {
        val[key]=-1;
    }
}
