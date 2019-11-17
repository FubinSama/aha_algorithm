package 第2章;

import java.util.Scanner;

public class 模拟链表 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] data = new int[101];
        int[] next = new int[101];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
            if(i != n-1) next[i] = i+1;
            else next[i] = -1;
        }

        int x = sc.nextInt();
        data[n++] = x;
        int i=0,j=0;
        while (data[i] < x) {
            j = i;
            i = next[i];
        }
        next[n-1] = i;
        next[j] = n-1;

        for (int k = 0; k != -1; k = next[k]) {
            System.out.print(data[k] + " ");
        }
    }
}
