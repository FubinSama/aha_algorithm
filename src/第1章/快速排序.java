package 第1章;

import java.util.Scanner;

public class 快速排序 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[101];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        quickSort(a, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }

    private static void quickSort(int[] a, int left, int right) {
        if(left >= right) return;
        int i=left+1,j=right, tmp=a[left];
        while (i != j){
            while (a[j]>=tmp && i<j) --j; //从右往左找第一个比tmp小的数
            while (a[i]<=tmp && i<j) ++i; //从左往右找第一个比tmp大的数
            if (i < j) { //如果j哨兵和i哨兵未相遇
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //将基准数tmp归位
        a[left] = a[i];
        a[i] = tmp;

        quickSort(a, left, i-1); //继续处理左边的
        quickSort(a, i+1, right); //继续处理右边的
    }
}
