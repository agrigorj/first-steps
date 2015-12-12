import java.util.Arrays;
import java.util.Random;


/**
 * Created by agrigorj on 11/12/15.
 */
public class Genereerimine {
    static int empty[][]=new int[9][9];
    static int filled[][]=new int[9][9];
    static int forUser [][]=new int [][]
                   {{1,0,0,1,0,1,1,1,0},
                    {1,1,0,1,0,0,1,0,1},
                    {1,1,1,0,1,0,1,0,1},
                    {1,0,1,0,0,1,1,1,0},
                    {1,0,1,1,0,1,1,0,0},
                    {1,0,0,0,1,1,1,1,0},
                    {1,0,1,0,1,1,1,0,0},
                    {0,0,1,1,0,0,1,1,1},
                    {1,1,0,0,1,0,1,0,1}} ;
    public static void main(String[] args) {
        int[] firstRow = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(firstRow);
        for (int i = 0; i <9 ; i++) {
            for (int j = 1; j <9 ; j++) {
                empty[0][i]=firstRow[i];
                empty[j][i]=0;
            }
        }
        shuffleforUser(forUser);
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if (forUser[i][j] == 1) {
                    forUser[i][j] = 0;
                } else {
                    forUser[i][j] = sudoku(0, 0, filled)[i][j];

                }

            }
        }

        print(forUser);

    }
    static void shuffleArray(int[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i+1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;

        }
    }
    static void shuffleforUser(int[][] ar)
    {
        Random rnd = new Random();

        for (int i = 0 ; i < 9; i++) {
            for (int j = 0; j < 9 ; j++) {
            int index = rnd.nextInt(9);
            int a = ar[i][index];
            ar[i][index] = ar[i][j];
            ar[i][j] = a;
            }

        }
    }
    public static boolean kontroll(int x, int y,int[][] filled){
        String temp= "";
        for (int i = 0; i <9 ; i++) {
            temp+=Integer.toString(filled[i][y]);
            temp+=Integer.toString(filled[x][i]);
            temp+=Integer.toString(filled[(x/3)*3+i/3] [(y/3)*3+i%3]);
        }
        int count=0, idx=0;
        while ((idx=temp.indexOf(Integer.toString(filled[x][y]),idx))!=-1)
        { idx++; count++;}
        return count==3;
    }
    public static int[][] sudoku(int y, int x, int[][]filled) {
            while (!kontroll(8, 8, filled) || filled[8][8] == 0) {
                if(empty[y][x]!=0){
                    filled[y][x]=empty[y][x];
                    int yy, xx;
                    if (x == 8) {yy = y + 1;xx = 0;} else {yy = y;xx = x + 1;}
                    sudoku(yy, xx, filled);
                }else{
                if (filled[y][x] < 9) {
                    filled[y][x]++;
                    if (kontroll(y, x, filled)) {
                        int yy, xx;
                        if (x == 8) {yy = y + 1;xx = 0;} else {yy = y;xx = x + 1;}
                        sudoku(yy, xx, filled);
                    }
                } else {
                    filled[y][x] = 0;
                    break;
                }

            }
            }
            return filled;

        }
    public static void print(int[][] grid) {
        System.out.println();
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    }




