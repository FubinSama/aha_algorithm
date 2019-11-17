package 第5章;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 城市地图 {
    private static Scanner sc = new Scanner(System.in);

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = 999_999;
    static Deque<Integer> s = new LinkedList<>();
    static Object[] rt;

    public static void main(String[] args) {
        n = sc.nextInt(); //节点个数
        int m = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = 999_999;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int d = sc.nextInt();
            map[x][y] = d;
        }
        visited[0] = true;
        s.addLast(0);
        dfs(0, 0);
        System.out.println(min);
        for (Object o : rt){
            System.out.print(((int)o+1)+" ");
        }
    }

    private static void dfs(int i, int cur) {

        if (cur >= min) return;
        if (i==n-1){
            if (cur < min) {
                min = cur;
                rt = s.toArray();
                return;
            }
        }

        for (int j = 0; j < n; j++) {
            if (!visited[j] && map[i][j] != 999_999) {
                visited[j] = true;
                s.addLast(j);
                dfs(j, cur+map[i][j]);
                s.removeLast();
                visited[j] = false;
            }
        }
    }
}
