package 第1章;

import java.io.IOException;
import java.util.Scanner;

public class 桶排序 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] book = new int[1001];
        for (int i = 0; i <= 1000; i++) {
            book[i] = 0;
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            book[sc.nextInt()]++;
        }
        for (int i = 1000; i >= 0; i--)
//        for (int i = 0; i <= 1000; i++)
            for (int j = 0; j < book[i]; j++)
                System.out.print(i+" ");
        System.out.println();
    }
}
