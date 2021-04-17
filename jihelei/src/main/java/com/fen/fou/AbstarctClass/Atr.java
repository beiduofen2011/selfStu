package com.fen.fou.AbstarctClass;

public class Atr {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int row = a.length;
        int col = a[0].length;
        int i=0,j=0;
        int count =0;
        int jmin =0,jmax =col-1 ;
        int imin =0,imax =row-1 ;
        while ( i < row/2 ){
            if (count % 4 == 0) {
                count++;
                for (int g = jmin ; g < jmax ; g++){
                    System.out.println(a[i][g]);
                }
                i++;
                jmin++;

            }
            if (count % 4 == 1) {
                count++;
                for (int g = imin ; g < imax ; g++){
                    System.out.println(a[g][j]);
                }
                jmax -- ;
                j = col - 1;

            }
            if (count % 4 == 2) {
                i  =  row - 1;
                count++;

                for (int g = imin ; g < imax ; g++){
                    System.out.println(a[i][g]);
                }
            }
            if (count % 4 == 3) {
                j = 0;
                count++;
                for (int g = jmin ; g < jmax ; g++){
                    System.out.println(a[i][j]);
                }
            }
        }
    }
}
