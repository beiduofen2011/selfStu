package com.fen.fou.AbstarctClass;

public class Asssss {
    public static void main(String[] args) {

        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        clockWise(a);
    }
    public static void clockWise(int[][] data) {
        //行长度
        int row = data.length;
        //列长度
        int column = 0;
        for (int i = 0; i < row; i++) {
            column = data[i].length;
        }
        //若N*N二维数组只有一个元素时
        if (row == 1 && column == 1) {
            System.out.print(data[row - 1][column - 1] + " ");
            return;
        }
        //打印第一行
        for (int i = 0; i < column; i++) {
            System.out.print(data[0][i] + " ");
        }
        //打印最后一列
        for (int i = 1; i < row; i++) {
            System.out.print(data[i][column - 1] + " ");
        }
        //打印最后一行
        for (int i = column - 2; i >= 0; i--) {
            System.out.print(data[row - 1][i] + " ");
        }
        //打印第一列
        for (int i = row - 2; i >= 1; i--) {
            System.out.print(data[i][0] + " ");
        }
        //若行、列还有元素未打印
        if (row - 2 > 0 && column - 2 > 0) {
            //构造新的二维数组
            int array[][] = new int[row - 2][column - 2];
            for (int i = 1; i <= row - 2; i++) {
                for (int j = 1; j <= column - 2; j++) {
                    array[i - 1][j - 1] = data[i][j];
                }
            }
            //递归
            clockWise(array);
        }
    }
}
