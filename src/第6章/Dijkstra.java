package 第6章;

import java.util.Scanner;

/*
    集合s：已经确定是最短路程的顶点集。
    集合l：还未确定是最短路径的顶点集。
    book用来标记属于集合s还是集合l。
    dist用来记录最终结果。
    算法：每次从集合l中找到距离集合s最短的定点，将它归入集合s，
        并对剩余的l集合中的结点重新更新它们跟集合s的最短距离。
 */
public class Dijkstra {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int st = sc.nextInt() - 1;
        int[][] e = new int[n][n];
        boolean[] book = new boolean[n];
        int[] dist = new int[n];
        String[] path = new String[n];
//        int[] path = new int[n];
        int inf = 999_999;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) e[i][j] = 0;
                else e[i][j] = inf;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int s = sc.nextInt();
            e[x][y] = s;
        }
        for (int i = 0; i < n; i++) {
            dist[i] = e[st][i];
            path[i] = (st+1)+","+(i+1);
        }
        book[st] = true;
        for (int i = 0; i < n-1; i++) {
            int min = inf;
            int u = 0;
            for (int j = 0; j < n; j++) { //找到距离开始集合距离最小的定点
                if (!book[j] && dist[j] < min){
                    min = dist[j];
                    u = j;
                }
            }
            book[u] = true;
            for (int j = 0; j < n; j++) {
                if (!book[j] && dist[j] > dist[u]+e[u][j]) {
                    dist[j] = dist[u] + e[u][j];
//                    path[j] = u;
                    path[j] = path[u] +","+ (j+1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(path[i]);
//            printPath(path, i, st);
//            System.out.println();
        }
}

    private static void printPath(int[] path, int i, int st){
        if (i == st) {
            System.out.print((st+1));
            return;
        }
        printPath(path, path[i], st);
        System.out.print(","+(i+1));
    }
}
