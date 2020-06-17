package com.yiqiandewo.recursion;

public class Maze {

    public static void main(String[] args) {
        //1是墙 0是未做过的路
        int maze[][] = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };
        mazeSolving(maze, 5, 1);

    }


    //2为通路 3为走过但走不通
    public static boolean mazeSolving(int[][] maze, int i, int j) {
        if ((i == 5) && (j == 6)) {
            maze[i][j] = 2;
            //出口
            for (int k = 0; k < maze.length; k++) {
                for (int l = 0; l < maze[0].length; l++) {
                    System.out.print(maze[k][l] + " ");
                }
                System.out.println();
            }
            return true;
        } else {
            if (maze[i][j] == 0) { //没走过的路
                //假定为通路
                maze[i][j] = 2;

                if (mazeSolving(maze, i-1, j)) { //上
                    return true;
                } else if (mazeSolving(maze, i, j-1)) { //左
                    return true;
                } else if (mazeSolving(maze, i+1, j)) { //下
                    return true;
                } else if (mazeSolving(maze, i, j+1)) { //右
                    return true;
                } else { //走不通
                    maze[i][j] = 3;
                    return false;
                }
            } else {  //是墙 或者通路 或者 死路
                return false;
            }
        }
    }
}
