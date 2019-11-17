package 第6章;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BellmanFond_Queue {
    private static Scanner sc = new Scanner(System.in);
    private static final int inf = 999_999;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];
        int[] w = new int[m];
        int[] first = new int[n];
        for (int i = 0; i < n; i++) {
            first[i] = -1;
        }
        int[] next = new int[m];
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dist[i] = inf;
        }
        //求顶点1到其他顶点的最短距离
        dist[0] = 0;
        q.add(0);
        visited[0] = true;

        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt() - 1;
            v[i] = sc.nextInt() - 1;
            w[i] = sc.nextInt();
            next[i] = first[u[i]];
            first[u[i]] = i;
        }
        while (!q.isEmpty()){
            int vertex = q.remove(); //顶点
            for (int k = first[vertex]; k != -1; k = next[k]){ //k为vertex到其他顶点的
                if (dist[u[k]] + w[k] < dist[v[k]]) {
                    dist[v[k]] = dist[u[k]] + w[k];
                    if (!visited[v[k]]) {
                        q.add(v[k]);
                        visited[v[k]] = true;
                    }
                }
            }
            visited[vertex] = true;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
