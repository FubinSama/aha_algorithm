package 第7章;

import java.util.Scanner;

public class 并查集 {
    private static Scanner sc = new Scanner(System.in);

    private static int getBoss(int[] f, int x){
        return f[x] == x ? x : (f[x] = getBoss(f, f[x]));
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) f[i] = i;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            f[getBoss(f, y)] = getBoss(f, x);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(f[i]+1 + " ");
            if (f[i] == i) ++sum;
        }
        System.out.println();
        System.out.println(sum);
    }
}
