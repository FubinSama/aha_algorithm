package 第4章;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 解救小哈 {
    private static Scanner sc = new Scanner(System.in);

    static class Solution{
        int p;
        int q;
        int rt = Integer.MAX_VALUE;
        int[][] map;
        boolean[][] book;
        int[][] next = {
                {0,1},//右
                {1,0},//下
                {0,-1},//左
                {-1,0}//上
        };

        public Solution(int p, int q, int[][] map) {
            this.p = p;
            this.q = q;
            this.map = map;
            this.book = new boolean[map.length][map[0].length];
        }

        private void dfs(int x, int y, int step){
            if (x==p && y==q){
                rt = Math.min(rt, step);
                return;
            }
//            System.out.println(x+":"+y);
            for (int i = 0; i < 4; i++) {
                int tx = x + next[i][0];
                int ty = y + next[i][1];
                //判断是否越界
                if (tx<0||ty<0||tx>=map.length||ty>=map[0].length) continue;
                if (map[tx][ty]==0 && !book[tx][ty]){//判断是否为未走过的空地
                    book[tx][ty] = true;
                    dfs(tx, ty, step+1);
                    book[tx][ty] = false;
                }
            }
        }
    }

    static class Note{
        int x,y,s;

        public Note(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int stx = sc.nextInt()-1;
        int sty = sc.nextInt()-1;
        int edx = sc.nextInt()-1;
        int edy = sc.nextInt()-1;

//        Solution s = new Solution(edx, edy, map);
//        s.book[stx][sty] = true;
//        s.dfs(stx, sty, 0);
//        if(s.rt == Integer.MAX_VALUE){
//            System.out.println("No Way!");
//        } else {
//            System.out.println(s.rt);
//        }

        int[][] next = {
                {0,1},//右
                {1,0},//下
                {0,-1},//左
                {-1,0}//上
        };

        Queue<Note> q = new LinkedList<>();
        boolean[][] book = new boolean[n][m];
        q.add(new Note(stx, sty, 0));
        Note tmp;
        boolean flag = false;
        while (!q.isEmpty()){
            tmp = q.remove();
            for (int i = 0; i < 4; i++) {
                int tx = tmp.x + next[i][0];
                int ty = tmp.y + next[i][1];
                //判断是否越界
                if (tx<0||ty<0||tx>=map.length||ty>=map[0].length) continue;
                if (map[tx][ty]==0 && !book[tx][ty]) {//判断是否为未走过的空地
                    book[tx][ty] = true;
                    q.add(new Note(tx, ty, tmp.s+1));
                    if (tx==edx && ty==edy) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        if (q.isEmpty()){
            System.out.println("No Way!");
        } else {
            System.out.println(((LinkedList<Note>) q).removeLast().s);
        }
    }
}
