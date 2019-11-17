package 第3章;

import java.util.Arrays;

public class 等式成立 {

    static class Solution{
        int cnt = 0;
        int[] a = new int[9];
        boolean[] visit = new boolean[10];
        void dfs(int i){
            if(i == 9) {
                if(a[0]*100+a[1]*10+a[2]+a[3]*100+a[4]*10+a[5]==a[6]*100+a[7]*10+a[8]) {
                    Arrays.stream(a).forEach(x -> System.out.print(x));
                    System.out.println();
                    ++cnt;
                }
            }
            for (int j=1; j<10; ++j){
                if(!visit[j]) {
                    visit[j] = true;
                    a[i] = j;
                    dfs(i+1);
                    visit[j] = false;
                }
            }
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.dfs(0);
//        System.out.println(s.cnt/2);
//    }

    public static void main(String[] args) {
        int cnt = 0;
        for (int a = 1; a < 10; a++)
            for (int b = 1; b < 10; b++)
                if(a != b) for (int c = 1; c < 10; c++)
                    if(c!=b && c!=a) for (int d = 1; d < 10; d++)
                        if(d!=c && d!=b && d!=a) for (int e = 1; e < 10; e++)
                            if(e!=d && e!=c && e!=b && e!=a) for (int f = 1; f < 10; f++)
                                if(f!=e && f!=d && f!=c && f!=b && f!=a) for (int g = 1; g < 10; g++)
                                    if(g!=f && g!=e && g!=d && g!=c && g!=b && g!=a) for (int h = 1; h < 10; h++)
                                        if(h!=g && h!=f && h!=e && h!=d && h!=c && h!=b && h!=a)
                                            for (int i = 1; i < 10; i++)
                                                if(i!=h && i!=g && i!=f && i!=e && i!=d && i!=c && i!=b && i!=a)
                                                    if(a*100+b*10+c+d*100+e*10+f==g*100+h*10+i){
                                                        System.out.println((a*100+b*10+c)+"+"+(d*100+e*10+f)+"="+(h*100+g*10+f));
                                                        ++cnt;
                                                    }
        System.out.println(cnt/2);
    }

}
