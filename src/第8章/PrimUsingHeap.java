package 第8章;

import java.util.Scanner;

public class PrimUsingHeap {

    private static Scanner sc  = new Scanner(System.in);
    static int n;
    static int m;
    static boolean[] book;
    static int[] dist;
    static int[] h;
    static int[] pos;
    static int[][] map;

    private static void swap(int x, int y){
        int t = h[x];
        h[x] = h[y];
        h[y] = t;
        t = pos[h[x]];
        pos[h[x]] = pos[h[y]];
        pos[h[y]] = t;
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        book = new boolean[n+1];//用来标记是否被选中
        dist = new int[n+1]; //用来记录边到选中集的距离
        h = new int[n+1];
        pos = new int[n+1];
        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
            map[i][i] = 0;
        }

        int a, b, c;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map[a][b] = c;
            map[b][a] = c;
        }
    }
}
