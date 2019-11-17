package 第1章;

import java.util.Scanner;

public class 冒泡排序 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Student[] s = new Student[100];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
            s[i] = new Student(sc.next(), sc.nextInt());
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j+1 < n-i; j++) {
                if(s[j].compareTo(s[j+1]) < 0){
                    Student t = s[j];
                    s[j] = s[j+1];
                    s[j+1] = t;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(s[i].name + " ");
        }

    }

    static class Student implements Comparable<Student>{
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student s) {
            return this.score - s.score;
        }
    }
}
