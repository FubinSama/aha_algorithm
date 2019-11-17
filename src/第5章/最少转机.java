package 第5章;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 最少转机 {
    private static Scanner sc = new Scanner(System.in);

    static class Note{
        int x,s;

        public Note(int x, int s) {
            this.x = x;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt() - 1;
        int e = sc.nextInt() - 1;
        boolean[][] map = new boolean[n][n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            map[x][y] = true;
            map[y][x] = true;
        }
        Queue<Note> q = new LinkedList<>();
        visited[s] = true;
        q.add(new Note(s, 0));
        boolean flag = false;
        while (!q.isEmpty()){
            Note tmp = q.remove();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && map[tmp.x][i]){
                    visited[i] = true;
                    q.add(new Note(i, tmp.s+1));
                    if (i==e) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        if (q.isEmpty()) System.out.println("impossible");
        else System.out.println(((LinkedList<Note>) q).removeLast().s);
    }
}
