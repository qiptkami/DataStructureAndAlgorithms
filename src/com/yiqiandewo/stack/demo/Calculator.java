package com.yiqiandewo.stack.demo;

import com.yiqiandewo.stack.LinkedListStack;

/**
 * 中缀表达式计算器
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "29-40/(2+8)*2";
        Calculator calculator = new Calculator();
        calculator.postfixExpressionEvaluation(expression);
    }

    //后缀表达式求值
    public void postfixExpressionEvaluation(String expression) {
        //定义数栈和操作符栈
        LinkedListStack<Integer> stackOfNum = new LinkedListStack();
        LinkedListStack<Character> stackOfOperator = new LinkedListStack<>();

        int index = 0, num = 0;
        while (index < expression.length()) {
            char ch = expression.charAt(index);
            //如果是数字
            if (!isOperator(ch)) {
                num = num * 10 + ch - '0';
                if (index == expression.length()-1) {
                    stackOfNum.push(num);
                }
                index++;
            } else {  //操作符
                if (num != 0) {
                    stackOfNum.push(num);
                    num = 0;
                }
                //如果操作符栈为空 直接入栈
                if (stackOfOperator.isEmpty()) {
                    stackOfOperator.push(ch);
                    index++;
                } else {
                    //判断该操作符与栈顶操作符的优先级
                    //如果该操作符优先级高于栈顶操作符的优先级或相同 入栈
                    if ((priority(stackOfOperator.getTop(), ch) == '<')) {
                        stackOfOperator.push(ch);
                        index++;
                    } else if ((priority(stackOfOperator.getTop(), ch) == '=')){
                        stackOfOperator.pop();
                        index++;
                    } else {
                        //如果该操作符优先级低于栈顶操作符的优先级 从数栈中取出两个数 从操作符栈取出栈顶操作符 计算
                        int num1 = stackOfNum.pop();
                        int num2 = stackOfNum.pop();
                        char operator = stackOfOperator.pop();
                        int res = calculate(num1, num2, operator);
                        //将结果入栈
                        stackOfNum.push(res);
                    }
                }
            }
        }
        while (!stackOfOperator.isEmpty()) {
            int num1 = stackOfNum.pop();
            int num2 = stackOfNum.pop();
            char operator = stackOfOperator.pop();
            int res = calculate(num1, num2, operator);
            //将结果入栈
            stackOfNum.push(res);
        }
        System.out.println(stackOfNum.getTop());
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*'|| ch == '/'|| ch == '(' || ch == ')';
    }

    //获取theta所对应的索引
    private int getIndex(char operator)  {
        int index = -1;
        if (operator == '+') {
            index = 0;
        } else if (operator == '-') {
            index = 1;
        } else if (operator == '*') {
            index = 2;
        } else if (operator == '/') {
            index = 3;
        } else if (operator == '(') {
            index = 4;
        } else if (operator == ')') {
            index = 5;
        }
        return index;
    }

    //优先级
    private char priority(char operator1, char operator2) {
        char[][] priority ={
                { '>','>','<','<','<','>'},
                { '>','>','<','<','<','>'},
                { '>','>','>','>','<','>'},
                { '>','>','>','>','<','>'},
                { '<','<','<','<','<','='},
                { '>','>','>','>','0','>'},
                { '<','<','<','<','<','0'}
        };

        int index1 = getIndex(operator1);
        int index2 = getIndex(operator2);
        return priority[index1][index2];
    }

    private int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
        }
        return -1;
    }

}
