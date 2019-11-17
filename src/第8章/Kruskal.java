package 第8章;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int u;
    public int v;
    public int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}

public class Kruskal {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] f = new int[n+1];
        for (int i = 0; i < n + 1; i++) { //并查集初始化
            f[i] = i;
        }
        Edge[] edges = new Edge[m];
        int a, b, c;
        for (int i = 0; i < m; i++) { //读入边
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            edges[i] = new Edge(a, b, c);
        }
        Arrays.sort(edges); //对边排序
        int cnt = 0;//记录选用的边数，当为n-1时，即可提前退出循环
        int sum = 0;//总开销
        for (int i = 0; i < m; i++) {
            if (merge(f, edges[i].u, edges[i].v)){
                sum += edges[i].w;
                ++cnt;
            }
            if (cnt == n-1) break;
        }
        System.out.println(sum);
    }

    private static int getParent(int[] f, int i){
        return f[i] == i ? f[i] : (f[i] = getParent(f, f[i]));
    }

    private static boolean merge(int[] f, int u, int v){
        int t1 = getParent(f, u);
        int t2 = getParent(f, v);
        if(t1!= t2){
            f[t2] = t1;
            return true;
        }
        return false;
    }
}
