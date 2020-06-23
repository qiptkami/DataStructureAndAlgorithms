package com.yiqiandewo.divideandconquer;

/**
 * 分治
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoiTower(5, 'a', 'b', 'c');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //把出去最下面的盘移动到B
            hanoiTower(num-1, a, c, b);
            //把最下面的盘移动到C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //把B的所有盘移动到C
            hanoiTower(num-1, b, a, c);
        }
    }
}
