package 第3章;

import java.util.Scanner;

public class 炸弹人 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] map = new char[55][];
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == '.'){ //这个点是平地
                    int tmpSum = 0;
                    for (int k = 0; k < 4; k++) {
                        tmpSum += getOneDirection(map, i, j, k);
                    }
                    max = Math.max(max, tmpSum);
                }
            }
        }

        System.out.println(max);
    }


    /*
    0.向上
    1.向下
    2.向左
    3.向右
     */
    private static int getOneDirection(char[][] map, int x, int y, int direction){
        int cnt = 0;
        while (map[x][y] != '#'){
            if(map[x][y] == 'G') ++cnt;
            if (direction == 0) --x;
            else if (direction == 1) ++x;
            else if (direction == 2) --y;
            else ++y;
        }
        return cnt;
    }
}
