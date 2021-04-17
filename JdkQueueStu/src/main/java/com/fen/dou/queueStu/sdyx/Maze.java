package com.fen.dou.queueStu.sdyx;

import java.util.LinkedList;
import java.util.Scanner;

public class Maze {
    private static MazeNode[][] maze;
    public static void main(String[] args) {
        //完成整个迷宫二维数组的建立
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入迷宫共有多少行");
        int row = scanner.nextInt();
        System.out.println("请输入迷宫共有多少列");
        int col = scanner.nextInt();
        maze = new MazeNode[row][col];
        System.out.println("输入迷宫的元素");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int next = scanner.nextInt();
                maze[i][j] = new MazeNode(i,j);
                maze[i][j].setValue(next);
            }
        }

        maze();
    }

    private static void maze() {
        //创建一个栈，用来深度优先遍历
        LinkedList<MazeNode> stack = new LinkedList<>();

        //确定入口
        stack.push(maze[0][0]);
        //要么栈空退出，要么到出口退出
        while (stack.peek() != null && (stack.peek().getX()!=maze.length-1 || stack.peek().getY()!=maze[0].length-1)) {
            //拿到栈顶
            MazeNode peek = stack.peek();
            int x = peek.getX();
            int y = peek.getY();
            //判断向下是否可走
            if((x+1)<maze.length && maze[x+1][y].getValue()==0 && maze[x][y].isDown()) {
                //先把来回的路封死
                maze[x][y].setDown(false);
                maze[x+1][y].setUp(false);
                //下面可走，则直接把下一个元素入栈，从下一个节点开始走
                stack.push(maze[x+1][y]);
                continue;
            } else if((y+1)<maze[0].length && maze[x][y+1].getValue() == 0 && maze[x][y].isRight()) {
                //往右走
                maze[x][y].setRight(false);
                maze[x][y+1].setLeft(false);
                //成功走到右边，入栈
                stack.push(maze[x][y+1]);
                continue;
            } else if((y-1)>=0 && maze[x][y-1].getValue()==0 && maze[x][y].isLeft()) {
                //往左走
                maze[x][y].setLeft(false);
                maze[x][y-1].setRight(false);

                stack.push(maze[x][y-1]);
                continue;
            } else if((x-1)>=0 && maze[x-1][y].getValue()==0 && maze[x][y].isUp()) {
                //往上走
                maze[x][y].setUp(false);
                maze[x-1][y].setDown(false);

                stack.push(maze[x-1][y]);
                continue;
            }
            stack.pop();
        }
        if(stack.peek() == null) {
            System.out.println("没有找到路径");
        } else {
            while(!stack.isEmpty()){
                MazeNode pop = stack.pop();
                pop.setValue(6);
            }
            //打印路径
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    System.out.print(maze[i][j].getValue()+" ");
                }
                System.out.println();
            }
        }
    }
}
