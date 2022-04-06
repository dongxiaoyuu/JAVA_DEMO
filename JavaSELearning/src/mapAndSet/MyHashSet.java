package mapAndSet;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:自制哈希集合
 * User:dxy
 * Date:2022-04-05
 * Time:16:48
 */
public class MyHashSet {
    private List<Integer> hashSet;
    public MyHashSet() {
        hashSet=new ArrayList<Integer>();
    }

    public void add(int key) {
        if(!hashSet.contains(key)){
            hashSet.add(key);
        }
    }

    public void remove(int key) {
        for (int i = 0; i < hashSet.size(); i++) {
            if(hashSet.get(i)==key){
                hashSet.remove(i);
                break;
            }
        }
    }

    public boolean contains(int key) {
        return hashSet.contains(key);
    }
}
