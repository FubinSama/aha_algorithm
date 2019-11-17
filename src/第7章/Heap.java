package 第7章;

import java.util.Scanner;

public class Heap {
    private int[] base;
    private int n;
    /*
    左子树为2*(i+1)-1 = 2*i+1
    右子树为2*i+2
     */
    public Heap(int[] base, int n) {
        this.base = base;
        this.n = n;
    }

    private void swap(int i, int j){
        int tmp = base[i];
        base[i] = base[j];
        base[j] = tmp;
    }

    private void siftDown(int i){
        int t;//较小的节点的下标
        while (i*2+1 < n) {
            if (base[2*i+1] < base[i]) t = 2*i+1;
            else t = i;
            if (2*i+2 < n && base[2*i+2] < base[t]) t = 2*i+2;
            if (t != i){
                swap(t, i);
                i = t;
            } else break;
        }
    }

    private void siftDown2(int i){
        int t;//较大的节点的下标
        while (i*2+1 < n) {
            if (base[2*i+1] > base[i]) t = 2*i+1;
            else t = i;
            if (2*i+2 < n && base[2*i+2] > base[t]) t = 2*i+2;
            if (t != i){
                swap(t, i);
                i = t;
            } else break;
        }
    }

    private void create(){ //创建小顶堆
        for (int i = n/2 - 1; i >= 0; --i) {
            siftDown(i);
        }
    }

    private void create2(){ //创建大顶堆
        for (int i = n/2 - 1; i >= 0; --i) {
            siftDown2(i);
        }
    }

    private int deleteMin(){
        int tmp = base[0];
        base[0] = base[--n];
        siftDown(0);
        return tmp;
    }

    private void sort2(){
        while (n-- > 0){
            swap(0, n);
            siftDown2(0);
        }
    }

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] base = new int[n+5];
        for (int i = 0; i < n; i++) {
            base[i] = sc.nextInt();
        }
        Heap h = new Heap(base, n);
//        h.create();
////        for (int i = 0; i < n; i++) {
////            System.out.print(h.deleteMin()+" ");
////        }
        h.create2();
        h.sort2();
        for (int i = 0; i < n; i++) {
            System.out.print(h.base[i] + " ");
        }
    }
}
