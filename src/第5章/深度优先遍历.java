package 第5章;

import java.util.Scanner;

public class 深度优先遍历 {
    private static Scanner sc = new Scanner(System.in);

    static int n;
    static int m;
    static int[][] e;
    static boolean[] visited;
    static int sum;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        e = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                e[i][j] = -1;
            }
        }
        int x,y;
        for (int i = 0; i < m; i++) {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            e[x][y] = 1;
            e[y][x] = 1;
        }
        visited[0] = true;
        dfs(0);
    }

    private static void dfs(int i) {
        System.out.print(i+1+" ");
        ++sum;
        if (sum == n) return;
        for (int j = 0; j < n; j++) {
            if (e[i][j]>0 && !visited[j]){
                visited[j] = true;
                dfs(j);
            }
        }
    }
}
