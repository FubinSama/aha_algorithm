package 第4章;

public class 全排列 {

    public static void main(String[] args) {
        int[] cnt = {0};
        Solution s = new Solution(1, 9){
            @Override
            void out() {
                if(a[0]*100+a[1]*10+a[2]+a[3]*100+a[4]*10+a[5]==a[6]*100+a[7]*10+a[8]){
                    ++cnt[0];
                }
            }
        };
        s.execute();
        System.out.println(cnt[0]/2);
    }
}

abstract class Solution {
    int st;
    int ed;
    int[] a;
    boolean[] book;

    Solution(int st, int ed) {
        this.st = st;
        this.ed = ed;
        int n = ed - st + 1;
        this.a = new int[n];
        this.book = new boolean[n];
    }

    abstract void out();

    void execute() {
        dfs(0);
    }

    void dfs(int i) {
        if (i == ed-st+1) {
            out();
            return;
        }
        for (int j = st; j <= ed; j++) {
            if (!book[j-st]) {
                book[j-st] = true;
                a[i] = j;
                dfs(i + 1);
                book[j-st] = false;
            }
        }
    }
}