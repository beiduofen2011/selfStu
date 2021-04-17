package com.fen.dou.queueStu.gdyx;

import com.fen.dou.queueStu.sdyx.MazeNode;

import java.util.LinkedList;
import java.util.Scanner;

public class Maze2 {
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
        //创建一个队列来进行广度优先搜索
        LinkedList<MazeNode> queue = new LinkedList<>();

        //定义一个数组记录跳跃的过程
        MazeNode[][] mazeRecord = new MazeNode[maze.length][maze[0].length];

        //确定入口
        queue.push(maze[0][0]);

        while (queue.peek() != null) {
            //拿到队头
            MazeNode peek = queue.peek();
            int x = peek.getX();
            int y = peek.getY();
            if((y+1)<maze[0].length && maze[x][y+1].getValue() == 0 && maze[x][y].isRight()) {
                //往右走
                maze[x][y].setRight(false);
                maze[x][y+1].setLeft(false);
                //成功走到右边，入队
                queue.offer(maze[x][y+1]);
                //记录轨迹
                mazeRecord[x][y+1] = maze[x][y];
                //如果入队的是出口，说明已经找到，直接返回
                if(check(x,y+1)) {
                    break;
                }
            }
            if((x+1)<maze.length && maze[x+1][y].getValue()==0 && maze[x][y].isDown()) {
                //判断向下是否可走
                //先把来回的路封死
                maze[x][y].setDown(false);
                maze[x+1][y].setUp(false);
                //下面可走，则直接把下一个元素入栈，从下一个节点开始走
                queue.offer(maze[x+1][y]);
                //记录轨迹
                mazeRecord[x+1][y] = maze[x][y];
                //如果入队的是出口，说明已经找到，直接返回
                if(check(x+1,y)) {
                    break;
                }
            }
            if((y-1)>=0 && maze[x][y-1].getValue()==0 && maze[x][y].isLeft()) {
                //往左走
                maze[x][y].setLeft(false);
                maze[x][y-1].setRight(false);

                queue.offer(maze[x][y-1]);
                //记录轨迹
                mazeRecord[x][y-1] = maze[x][y];
                //如果入队的是出口，说明已经找到，直接返回
                if(check(x,y-1)) {
                    break;
                }
            }
            if((x-1)>=0 && maze[x-1][y].getValue()==0 && maze[x][y].isUp()) {
                //往上走
                maze[x][y].setUp(false);
                maze[x-1][y].setDown(false);

                queue.offer(maze[x-1][y]);
                //记录轨迹
                mazeRecord[x-1][y] = maze[x][y];
                //如果入队的是出口，说明已经找到，直接返回
                if(check(x-1,y)) {
                    break;
                }
            }
            queue.poll();
        }
        if(queue.peek() == null) {
            System.out.println("没有找到路径");
        } else {
            int x = maze.length-1;
            int y = maze[0].length-1;
            //修改正确路径
            while(true) {
                maze[x][y].setValue(6);
                if(x==0 && y==0) {
                    break;
                }
                MazeNode temp = mazeRecord[x][y];
                x = temp.getX();
                y = temp.getY();
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

    //检查入队的是否是出口
    private static boolean check(int x, int y) {
        return  x==maze.length-1 && y==maze[0].length-1;
    }
}
