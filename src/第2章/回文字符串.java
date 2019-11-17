package 第2章;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 回文字符串 {

    private static Scanner sc = new Scanner(System.in);

//    public static void main(String[] args) {
//        String str = sc.next();
//        char[] chs = str.toCharArray();
//        int len = str.length();
//        int top = 0;
//        char[] s = new char[101];
//        for (int i = 0; i <= (str.length()-1)/2; i++) {
//            s[top++] = chs[i];
//        }
//        boolean flag = true;
//        for (int i=str.length()/2; i<chs.length; ++i) {
//            if (s[--top] != chs[i]){
//                flag = false;
//                break;
//            }
//        }
//        System.out.println(flag ? "YES" : "NO");
//    }

    public static void main(String[] args) {
        String str = sc.next();
        Deque<Character> s = new ArrayDeque<>((str.length()+1) / 2);
        char[] chs = str.toCharArray();
        boolean flag = true;
        for(int i = 0; i <= (str.length()-1)/2; ++i) {
            s.push(chs[i]);
        }
        for(int i=str.length()/2; i<str.length(); ++i){
            if(chs[i] != s.pop()){
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}
