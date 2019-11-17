package 第6章;

import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {
    private static Scanner sc = new Scanner(System.in);
    private static final int inf = 999_999;
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] u = new int[n];
        int[] v = new int[n];
        int[] w = new int[n];
        int[] dist = new int[n];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt()-1;
            v[i] = sc.nextInt()-1;
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            dist[i] = inf;
        }
        dist[0] = 0;
        int[] bak;
        for (int i = 0; i < n-1; i++) {
            bak = Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < m; j++) {
                if (dist[v[j]] > dist[u[j]] + w[j]){
                    dist[v[j]] = dist[u[j]] + w[j];
                }
            }
            if (Arrays.equals(bak, dist)) break;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i]+" ");
        }

        //检测是否含有负权回路
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (dist[v[i]] > dist[u[i]] + w[i]){
                flag = true;
                break;
            }
        }
    }
}
