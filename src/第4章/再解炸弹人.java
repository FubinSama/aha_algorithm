package 第4章;

import java.util.Scanner;

public class 再解炸弹人 {

    private static Scanner sc = new Scanner(System.in);

    static class Note{
        int x,y;

        public Note(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static int next[][] = {
            {0,1},//右
            {1,0},//下
            {0,-1},//左
            {-1,0}//上
    };

//    public static void main(String[] args) {
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        map = new char[n][];
//        for (int i = 0; i < n; i++) {
//            map[i] = sc.next().toCharArray();
//        }
//        boolean[][] book = new boolean[n][m];
//        Queue<Note> q = new LinkedList<>();
//        int rt = 0;
//        book[x][y] = true;
//        q.add(new Note(x, y));
//        while (!q.isEmpty()) {
//            Note tmp = q.remove();
//            rt = Math.max(rt, getSum(tmp.x, tmp.y));
//            for (int i = 0; i < 4; i++) {
//                int tx = tmp.x + next[i][0];
//                int ty = tmp.y + next[i][1];
//                if (map[tx][ty] == '.' && !book[tx][ty]) {
//                    book[tx][ty] = true;
//                    q.add(new Note(tx, ty));
//                }
//            }
//        }
//        System.out.println(rt);
//    }

    static class Solution{
        char[][] map;
        boolean[][] book;
        int rt = 0;
        int next[][] = {
                {0,1},//右
                {1,0},//下
                {0,-1},//左
                {-1,0}//上
        };

        public Solution(char[][] map) {
            this.map = map;
            this.book = new boolean[map.length][map[0].length];
        }

        public void dfs(int x, int y){
            rt = Math.max(getSum(x, y), rt);
            for (int i = 0; i < 4; i++) {
                int tx = x + next[i][0];
                int ty = y + next[i][1];
                if (map[tx][ty] == '.' && !book[tx][ty]){
                    book[tx][ty] = true;
                    dfs(tx, ty);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }
        Solution s = new Solution(map);
        s.book[x][y] = true;
        s.dfs(x, y);
        System.out.println(s.rt);
    }

    private static int getSum(int x, int y){
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += getOneDirection(x, y, i);
        }
        return sum;
    }

    /*
    0.右
    1.下
    2.左
    3.上
     */
    private static int getOneDirection(int x, int y, int i){
        int cnt = 0;
        while (map[x][y] != '#'){
            if (map[x][y] == 'G') ++cnt;
            x += next[i][0];
            y += next[i][1];
        }
        return cnt;
    }
}
