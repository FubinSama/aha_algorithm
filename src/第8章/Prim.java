package 第8章;

import java.util.Scanner;

public class Prim {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] book = new boolean[n+1];//用来标记是否被选中
        int[] dist = new int[n+1]; //用来记录边到选中集的距离
        int[][] map = new int[n+1][n+1];
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
        //选中第一个节点
        int minIndex = 1;
        book[minIndex] = true;
        for (int j = 1; j <= n; j++) {
            dist[j] = map[1][j];
        }
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            minIndex = getIndexOfMinFromNonSelection(book, dist);
            book[minIndex] = true;
            sum += dist[minIndex];
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(map[minIndex][j], dist[j]);
            }
        }
        System.out.println(sum);
    }
    private static int getIndexOfMinFromNonSelection(boolean[] book, int[] dist){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 2; i < dist.length; i++) {
            if (!book[i] && dist[i] < min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
