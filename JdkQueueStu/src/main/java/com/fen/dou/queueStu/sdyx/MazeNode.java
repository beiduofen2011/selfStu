package com.fen.dou.queueStu.sdyx;

public class MazeNode {
    //x坐标
    private int x;
    //y坐标
    private int y;
    //记录左边是否可走
    private boolean left;
    //记录右边是否可走
    private boolean right;
    //记录上边是否可走
    private boolean up;
    //记录下边是否可走
    private boolean down;
    //0表示可走，1表示不可走，6表示正确路线
    private int value;

    public MazeNode(int x,int y) {
        this.x = x;
        this.y = y;
        this.left = true;
        this.right = true;
        this.up = true;
        this.down = true;
    }

    public MazeNode() {
        this(-1,-1);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    @Override
    public String toString() {
        return "MazeNode{" +
                "value=" + value +
                '}';
    }
}