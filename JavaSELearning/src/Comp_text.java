import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-03-28
 * Time:21:06
 */

class Student  implements Cloneable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
    @Override
    public Student clone(){
        Student o=null;
        try{
            o= (Student) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return o;
    }


    //重写compareTo（）方法，指定比较规则，
    // 按照年龄的从大到小比较
    /*@Override
    public int compareTo(Object o) {
        Student s=(Student) o;
        if(this.age>s.age){
            return -1;
        }else if(this.age<s.age){
            return 1;
        }else {
            return 0;
        }
    }*/
}
public class Comp_text {

    public static void main(String[] args) {
        String s1=new String("196.125.93.7");
        System.out.println(s1.substring(5));//从指定索引截取到结尾
        System.out.println(s1.substring(0,5));//从0号索引截取到4（左闭右开）









       /* System.out.println(s1.toUpperCase());//转大写
        System.out.println(s2.toLowerCase());//转小写*/
        /*System.out.println(s1.charAt(0));//h(返回指定位置的字符)
        System.out.println(s1.indexOf('l'));//2(返回指定字符第一次出现的位置)*/



    }
    public static void main1(String[] args) {
        Student []students=new Student[]{
                new Student("lily", 15),
                new Student("coco", 10),
                new Student("joh", 19),
                new Student("kitty", 23),

        };
        Student []students2=students.clone();
        //可以使用sort方法比较啦
        //Arrays.sort(students);
        //按照重写的toString规则输出
        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.toString(students2));
        System.out.println(students==students2);//浅拷贝
    }
}
