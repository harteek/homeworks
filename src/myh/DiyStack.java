package myh;

import java.util.Scanner;
import java.util.Stack;

public class DiyStack {
    public static void main(String[] args) {
        try {
            System.out.println("请输入一个十进制数：");
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt(), temp = m;
            Stack<Integer> s = new Stack();
            while (temp > 0) {
                s.push(temp % 2); //二进制就是一直取除以2的余数
                temp /= 2;
            }
            System.out.print(m+"的二进制数为：");
            while (s.size() > 0) {
                System.out.print(s.pop());
            }
            System.out.println();
            temp = m;
            while (temp > 0) {
                s.push(temp % 8); //八进制就是一直取除以8的余数
                temp /= 8;
            }
            System.out.print(m+"的八进制数为：");
            while (s.size() > 0) {
                System.out.print(s.pop());
            }
            System.out.println();
            temp = m;
            while (temp > 0) {
                s.push(temp % 16);//十六进制就是一直取除以16的余数
                temp /= 16;
            }
            System.out.print(m+"的十六进制数为：");
            while (s.size() > 0) {
                temp = s.pop();
                System.out.print((temp > 9 ? "" + (char) (temp - 10 + 'a') : temp)); //十六进制大于9的数要转成abcdef
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
