package myh;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        System.out.println("请输入表达式：");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack operStack = new ArrayStack(20);
        int index = 0 ;
        int num1 = 0;
        int num2 = 0;
        int oper= 0;
        int res = 0;
        char ch = ' ';
        while(true){
            ch = expression.substring(index,index+1).charAt(0);
            //判断
            if(operStack.isOper(ch)){
                //判断符号栈是否为空
                if(operStack.isEmpty()){
                    //不为空的话讨论优先级
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calculate(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    //如果为空直接入栈
                    operStack.push(ch);
                }
            }else{
                //如果是数，直接入栈
                numStack.push(ch-48);
            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }
        while(true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calculate(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println("表达式结果为："+numStack.pop());
    }
}

class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    public int peek(){
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断是否满
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空！");
            //return;抛出异常相当于return，不需要再return
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况,遍历时需要从栈顶开始显示
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i] + " ");
        }
    }

    //用数字来表示运算符的优先级，数字越大优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否为一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int calculate(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
