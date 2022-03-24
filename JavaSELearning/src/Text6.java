import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dxy
 * Date:2022-03-20
 * Time:14:05
 */

public class Text6 {

    public class Solution {
        public void merge(int A[], int m, int B[], int n) {
            for (int i = 0; i < n; i++) {
                A[m+i]=B[i];
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = 1; j < A.length-i; j++) {
                    if(A[j-1]>A[j]){
                        int tmp;
                        tmp=A[j-1];
                        A[j-1]=A[j];
                        A[j]=tmp;
                    }
                }
            }
        }
    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.nextLine();
            if(str1==null&&str1.length()>100){return;}
            String str2=String.valueOf(str1.charAt(0));
            for (int i = 0; i < str1.length(); i++) {
                if(!str2.contains(String.valueOf(str1.charAt(i)))){
                    str2+=str1.charAt(i);
                }
            }
            System.out.println(str2);
            //

        }
    }
}
