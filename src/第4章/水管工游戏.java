package 第4章;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 水管工游戏 {
    private static Scanner sc = new Scanner(System.in);

    static class Note{
        int x,y;

        public Note(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+(x+1)+","+(y+1)+")";
    }
    }
    /*
    1.上右
    2.下右
    3.下左
    4.上左
    5.左右
    6.上下
     */
    static class Solution{
        int[][] map;
        boolean[][] book;
        int n;
        int m;
        boolean flag = false;
        Deque<Note> rt = new LinkedList<>();

        public Solution(int[][] map, boolean[][] book) {
            this.map = map;
            this.book = book;
            this.n = map.length;
            this.m = map[0].length;
        }

        /*
        front:进水口
            1.左 2.上 3.右 4.下
         */
        void dfs(int x, int y, int front){
            if (x==n-1 && y==m) {
                flag = true;
                for (Note note : rt){
                    System.out.print(note);
                }
                System.out.println();
                return;
            }
            //判断是否越界
            if (x<0 || y<0 || x>=n || y>=m) return;
            if (book[x][y]) return;
            book[x][y] = true;
            rt.addLast(new Note(x, y));
            if (map[x][y] > 4){
                if (front==1) dfs(x, y+1, 1);
                else if (front==2) dfs(x+1, y, 2);
                else if (front==3) dfs(x, y-1, 3);
                else if (front==4) dfs(x-1, y, 4);
            } else if (map[x][y] > 0){
                if (front%2 == 1) {
                    dfs(x-1, y, 4);
                    dfs(x+1, y, 2);
                } else {
                    dfs(x, y+1, 1);
                    dfs(x, y-1, 3);
                }
            }
            book[x][y] = false;
            rt.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        boolean[][] book = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution(map, book);
        s.dfs(0, 0, 1);
        if (!s.flag) System.out.println("impossible");
    }
}
