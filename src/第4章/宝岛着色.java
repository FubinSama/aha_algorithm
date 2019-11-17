package 第4章;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 宝岛着色 {
    private static Scanner sc = new Scanner(System.in);

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] book;
    static int next[][] = {
            {0,1},//右
            {1,0},//下
            {0,-1},//左
            {-1,0}//上
    };

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        book = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int color = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!book[i][j] && map[i][j] > 0){
                    map[i][j] = color;
                    book[i][j] = true;
                    bfs(i, j, color++);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    static class Note{
        int x,y;

        public Note(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y, int color) {
        Queue<Note> q = new LinkedList<>();
        q.add(new Note(x, y));
        while (!q.isEmpty()){
            Note tmp = q.remove();
            for (int i = 0; i < 4; i++) {
                int tx = tmp.x + next[i][0];
                int ty = tmp.y + next[i][1];
                if (tx<0 || ty<0 || tx>=n || ty>=m) continue;
                if (!book[tx][ty] && map[tx][ty]>0){
                    book[tx][ty] = true;
                    map[tx][ty] = color;
                    q.add(new Note(tx, ty));
                }
            }
        }
    }
}
