package 第2章;

public class 解密QQ号 {
//    public static void main(String[] args) {
//        int[] a = new int[]{6,3,1,7,5,8,9,2,4};
//        Queue<Integer> q = new ArrayDeque<>();
//        Arrays.stream(a).forEach(x -> q.add(x));
//        boolean flag = true; //true->输出，false->插入到后面
//        while(! q.isEmpty()){
//            if (flag) System.out.print(q.poll());
//            else q.add(q.poll());
//            flag = !flag;
//        }
//    }

//    public static void main(String[] args) {
//        int[] a = new int[]{6,3,1,7,5,8,9,2,4};
//        int[] q = new int[102];
//        System.arraycopy(a, 0, q, 0, a.length);
//        int head=0, tail=a.length;
//        while(head < tail){
//            System.out.print(q[head]);
//            ++head;
//            q[tail] = q[head];
//            ++tail;
//            ++head;
//        }
//    }

    static class MyQueue{
        int[] base = new int[100];
        int head = 0;
        int tail = 0;
    }


    public static void main(String[] args) {
        int[] a = new int[]{6,3,1,7,5,8,9,2,4};
        MyQueue q = new MyQueue();
        System.arraycopy(a, 0, q.base, 0, a.length);
        q.tail = a.length;
        while(q.head < q.tail){
            System.out.print(q.base[q.head]);
            ++q.head;
            q.base[q.tail] = q.base[q.head];
            ++q.tail;
            ++q.head;
        }
    }
}
