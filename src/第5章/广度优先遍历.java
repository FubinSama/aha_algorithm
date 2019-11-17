package 第5章;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 广度优先遍历 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] e = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                e[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            e[x][y] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(0);
        while (!q.isEmpty()){
            int tmp = q.remove();
            System.out.print(tmp+1 + " ");
            for (int i = 0; i < n; i++) {
                if (!visited[i] && e[tmp][i]==1){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
