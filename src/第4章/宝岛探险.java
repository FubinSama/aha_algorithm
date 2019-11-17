package 第4章;

import java.util.Scanner;

public class 宝岛探险 {

    private static Scanner sc = new Scanner(System.in);

    static class Note{
        int x,y;

        public Note(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int next[][] = {
            {0,1},//右
            {1,0},//下
            {0,-1},//左
            {-1,0}//上
    };

    static class Solution{
        static int next[][] = {
                {0,1},//右
                {1,0},//下
                {0,-1},//左
                {-1,0}//上
        };
        int[][] map;
        boolean[][] book;
        int rt = 1;
        int n;
        int m;
        public Solution(int[][] map, boolean[][] book) {
            this.map = map;
            this.book = book;
            this.n = map.length;
            this.m = map[0].length;
        }

        public void dfs(int x, int y){
            for (int i = 0; i < 4; i++) {
                int tx = x + next[i][0];
                int ty = y + next[i][1];
                if (tx<0 || ty<0 || tx>=n || ty>=m) continue;
                if (!book[tx][ty] && map[tx][ty] > 0) {
                    book[tx][ty] = true;
                    this.rt += 1;
                    dfs(tx, ty);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int stx = sc.nextInt()-1;
        int sty = sc.nextInt()-1;
        int[][] map = new int[n][m];
        boolean[][] book = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
//        int sum = 1;
//        Queue<Note> q = new LinkedList<>();
//        book[stx][sty] = true;
//        q.add(new Note(stx, sty));
//        while (!q.isEmpty()){
//            Note tmp = q.remove();
//            for (int i = 0; i < 4; i++) {
//                int tx = tmp.x + next[i][0];
//                int ty = tmp.y + next[i][1];
//                if (tx<0 || ty<0 || tx>=n || ty>=m) continue;
//                if (!book[tx][ty] && map[tx][ty] > 0){
//                    book[tx][ty] = true;
//                    ++sum;
//                    q.add(new Note(tx, ty));
//                }
//            }
//        }
//        System.out.println(sum);

        Solution s = new Solution(map, book);
        s.book[stx][sty] = true;
        s.dfs(stx, sty);
        System.out.println(s.rt);
    }
}
