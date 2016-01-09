package Kontrolltood;

import java.util.Arrays;

/**
 * Koostage Java meetod, mis genereerib parameetrina etteantud n järgi n korda n täisarvumaatriksi, mille peadiagonaalil on ühed ning kõik ülejäänud elemendid on nullid.
 Write a method in Java to generate an integer matrix of size n x n (n is a parameter of the method) where elements on the principal (main) diagonal are ones and all other elements are zeros.

 public static int[][] yhik (int n)

 Koostage Java meetod, mis genereerib parameetrina etteantud n järgi niisuguse n korda n täisarvumaatriksi, mille iga elemendi väärtuseks on selle elemendi reaindeksi ja veeruindeksi korrutis (indeksid algavad nullist).

 * Created by agrigorj on 01/12/15.
 */
public class KT2_10 {
    public static void main (String[] args) {
        int[][] res = korraTabel (9);

    }
    public static int[][] korraTabel (int n) {
        int[][] a= new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                a[i][j]= i*j;

            }



            System.out.println(Arrays.toString(a[i]));

        }

        return a; // TODO!!! Your code here
    }
}

  /**  public static int[][] yhik (int n) {
        int[][] a= new int[n][n];
        for (int i = 0; i <n ; i++) {
                a[i][i]= 1;


            System.out.println(Arrays.toString(a[i]));

            }

        return a; // TODO!!! Your code here
    }
}*/
