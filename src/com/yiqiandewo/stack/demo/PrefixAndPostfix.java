package com.yiqiandewo.stack.demo;

import java.util.Stack;

public class PrefixAndPostfix {

    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        PrefixAndPostfix prefixAndPostfix = new PrefixAndPostfix();
        String s = prefixAndPostfix.toPolishNotation(expression);
        prefixAndPostfix.polishNotationEvaluation(s);
        String s1 = prefixAndPostfix.toReversePolishNotation(expression);
        prefixAndPostfix.reversePolishNotationEvaluation(s1);
    }

    /**
     * 将中缀表达式转为前缀表达式  波兰表达式
     * (1) 初始化两个栈：运算符栈S1和储存中间结果的栈S2
     * (2) 从右至左扫描中缀表达式
     * (3) 遇到操作数时，将其压入S2
     * (4) 遇到运算符时，比较其与S1栈顶运算符的优先级
     *     (4-1) 如果S1为空，或栈顶运算符为右括号')'，则直接将此运算符入栈
     *     (4-2) 否则，若优先级比栈顶运算符的较高或相等，也将运算符压入S1
     *     (4-3) 否则，将S1栈顶的运算符弹出并压入到S2中，再次转到(4-1)与S1中新的栈顶运算符相比较
     * (5) 遇到括号时：
     *     (5-1) 如果是右括号')'，则直接压入S1
     *     (5-2) 如果是左括号'('，则依次弹出S1栈顶的运算符，并压入S2，直到遇到右括号为止，此时将这一对括号丢弃
     * (6) 重复步骤(2)至(5)，直到表达式的最左边
     * (7) 将S1中剩余的运算符依次弹出并压入S2
     * (8) 依次弹出S2中的元素并输出，结果即为中缀表达式对应的前缀表达式
     */
    public String toPolishNotation(String expression) {
        Stack<Character> s1 = new Stack();  //辅助栈
        Stack s2 = new Stack();  //最终结果栈

        int len = expression.length();
        //从右往左扫描
        for (int i = len - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {  //如果字符是数字
                s2.push(ch);
            } else if (isOperator(ch)) {  //如果是操作符
                //否则比较优先级
                //如果当前操作符优先级低于栈顶
                while (!s1.empty() && s1.peek() != ')' && (priority(ch) < priority(s1.peek()))) {
                    //将辅助栈s1的栈顶弹出压入s2 然后再与s1栈顶比较
                    s2.push(s1.pop());
                }
                //退出上面的while循环 就说明栈为空或者为')'或者当前操作符的优先级等于或者高于栈顶元素  直接入栈
                s1.push(ch);
            } else if (ch == ')') {  //如果遇到')' 直接入栈s1
                s1.push(ch);
            } else if (ch == '(') {  //如果遇到'(' 弹出s1中栈顶元素并压入s2 直到遇到')' 两个括号一起丢弃
                while (s1.peek() != ')') {
                    s2.push(s1.pop());
                }
                s1.pop(); //将')'出栈
            }
        }

        while (!s1.empty()) { //如果s1中还有剩余 依次弹出并压入s2
            s2.push(s1.pop());
        }

        char[] chars = new char[s2.size()];
        int i = 0;
        while (!s2.empty()) {
            chars[i] = (char)s2.pop();
            i++;
        }
        return new String(chars);
    }

    /**
     * 将中缀表达式转为后缀表达式   逆波兰表达式
     * (1) 初始化两个栈：运算符栈S1和储存中间结果的栈S2
     * (2) 从左至右扫描中缀表达式
     * (3) 遇到操作数时，将其压入S2
     * (4) 遇到运算符时，比较其与S1栈顶运算符的优先级
     *     (4-1) 如果S1为空，或栈顶运算符为左括号'('，则直接将此运算符入栈
     *     (4-2) 否则，若优先级比栈顶运算符的高，也将运算符压入S1（注意转换为前缀表达式时是优先级较高或相同，而这里则不包括相同的情况）
     *     (4-3) 否则，将S1栈顶的运算符弹出并压入到S2中，再次转到(4-1)与S1中新的栈顶运算符相比较
     * (5) 遇到括号时
     *     (5-1) 如果是左括号'('，则直接压入S1
     *     (5-2) 如果是右括号')'，则依次弹出S1栈顶的运算符，并压入S2，直到遇到左括号为止，此时将这一对括号丢弃
     * (6) 重复步骤(2)至(5)，直到表达式的最右边
     * (7) 将S1中剩余的运算符依次弹出并压入S2
     * (8) 依次弹出S2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式（转换为前缀表达式时不用逆序）
     */
    public String toReversePolishNotation(String expression){
        Stack<Character> s1 = new Stack<>();
        Stack s2 = new Stack();
        int len = expression.length();
        //从左向右扫描
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {  //如果是数字
                s2.push(ch);
            } else if (isOperator(ch)) {//如果是操作符
                while (!s1.isEmpty() && s1.peek() != '(' && (priority(ch) <= priority(s1.peek()))) { //优先级小于等于
                    s2.push(s1.pop());
                }
                //如果栈为空 s1栈顶为'(' 或者当前操作符的优先级大于栈顶元素的优先级 直接入栈
                s1.push(ch);
            } else if (ch == '(') {
                s1.push(ch);
            } else if (ch == ')') {
                while (s1.peek() != '(') {
                    s2.push(s1.pop());
                }
                s1.pop();
            }
        }

        while (!s1.empty()) { //如果s1中还有剩余 依次弹出并压入s2
            s2.push(s1.pop());
        }

        int i = s2.size();
        char[] chars = new char[i];

        while (!s2.empty()) {
            chars[i-1] = (char)s2.pop();
            i--;
        }
        //结果需要逆序
        return new String(chars);
    }

    //前缀表达式求值   波兰表达式
    public void polishNotationEvaluation(String polishNotation) {
        System.out.println(polishNotation);
        int len = polishNotation.length();
        Stack<Integer> numStack = new Stack<>();
        //从右向左扫描
        for (int i = len-1; i >= 0 ; i--) {
            char ch = polishNotation.charAt(i);
            if (Character.isDigit(ch)) { //如果是数字
                numStack.push(ch - '0');
            } else {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                int res = calculate(num1, num2, ch);  //res = 栈顶元素 op 次顶元素
                numStack.push(res);
            }
        }

        System.out.println(numStack.peek());
    }

    //后缀表达式求值  逆波兰表达式
    public void reversePolishNotationEvaluation(String reversePolishNotation) {
        System.out.println(reversePolishNotation);
        int len = reversePolishNotation.length();
        Stack<Integer> stack = new Stack<>();

        //从左向右扫描
        for (int i = 0; i < len; i++) {
            char ch = reversePolishNotation.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int num1 = stack.pop();   //栈顶
                int num2 = stack.pop();   //次顶
                //res = 次顶元素 op 栈顶元素
                int res = calculate(num2, num1, ch);
                stack.push(res);
            }
        }
        System.out.println(stack.peek());

    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int priority(char op){
        switch (op) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
        }
        return -1;
    }

    private int calculate(int num1, int num2, char operator) {
        switch (operator) {
               case '+':
                   return num1 + num2;
               case '-':
                   return num1 - num2;
               case '*':
                   return num1 * num2;
               case '/':
                   return num1 / num2;
            }
            return -1;

    }

}
