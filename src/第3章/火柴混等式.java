package 第3章;

import java.io.IOException;

public class 火柴混等式 {

    private static int getNum() throws IOException {
        int num = 0;
        int digit;
        while (Character.isDigit(digit = (char)System.in.read())){
            num = num * 10 + (digit-'0');
        }
        System.in.close();
        return num;
    }

    public static void main(String[] args) throws IOException {
        int n = getNum() - 4;
        int cnt = 0;
        for (int i = 0; i < 11111; i++) {
            for (int j = 0; j < 11111; j++) {
                if (getCnt(i)+getCnt(j)+getCnt(i+j) == n) ++cnt;
            }
        }
        System.out.println(cnt);
    }

    private static int getCnt(int i) {
        int[] map = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        int sum = 0;
        while (i/10 != 0){
            sum += map [i%10];
            i /= 10;
        }
        sum += map[i];
        return sum;
    }
}
