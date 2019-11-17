package 第2章;

import java.util.*;

public class 小猫钓鱼 {
    public static void main(String[] args) {
        int[] a = {2,4,1,2,5,6};
        int[] b = {3,1,3,5,6,4};
        Deque<Integer> q1 = new ArrayDeque<>(); //小哼
        Deque<Integer> q2 = new ArrayDeque<>(); //小哈
        Deque<Integer> s = new ArrayDeque<>();
        Arrays.stream(a).forEach(x->q1.add(x));
        Arrays.stream(b).forEach(x->q2.add(x));
        int x; //当前出牌
        boolean flag = true; //true->q1,false->q2;
        while (!q1.isEmpty() && !q2.isEmpty()){
            x = flag ? q1.remove() : q2.remove();
            if(s.contains(x)) qGetFromS(flag?q1:q2, s, x);//可以用book状态数组做优化
            else s.push(x);
            flag = ! flag;
        }
        if (q1.isEmpty()) {
            myPrint(q2, s, "小哈");
        } else {
            myPrint(q1, s, "小哼");
        }
    }

    private static void myPrint(Deque<Integer> q, Deque<Integer> s, String name){
        System.out.println(name+"获胜！");
        System.out.print(name+"当前的手牌为：");
        for (Integer i : q) System.out.print(" " + i);
        System.out.println();
        System.out.print(s.isEmpty() ? "桌上已经没牌了！" : "桌上的牌从底往上是：");
        for (Integer i : s) System.out.print(" " + i);
        System.out.println();
    }

    private static void qGetFromS(Deque<Integer> q, Deque<Integer> s, int x) {
        q.add(x);
        while (s.peek() != x){
            q.add(s.pop());
        }
    }

}
