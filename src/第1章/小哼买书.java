package 第1章;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 小哼买书 {

    private static Scanner sc = new Scanner(System.in);

//    public static void main(String[] args){
//        int n = sc.nextInt();
//        boolean[] a = new boolean[1001];
//        int cnt = 0;
//        for (int i=0; i<n; ++i){
//            int x = sc.nextInt();
//            if(!a[x]){
//                a[x] = true;
//                ++cnt;
//            }
//        }
//        System.out.println(cnt);
//        boolean flag = true;
//        for(int i=1; i<=1000; ++i){
//            if(a[i]) {
//                if (flag) {
//                    flag = false;
//                } else {
//                    System.out.print(" ");
//                }
//                System.out.print(i);
//            }
//        }
//    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        int n = sc.nextInt();
        for (int i=0; i<n; ++i) {
            set.add(sc.nextInt());
        }
        System.out.println(set.size());
        set.stream().sorted().forEach(i -> System.out.print(i + " "));
    }
}