package Projekt;

import java.util.Random;


/**
 * Created by agrigorj on 11/12/15.
 * Selle klassi kirjutamisel abimaterjalina on kasutatud Sudoku Tutorial youtube video:  https://www.youtube.com/watch?v=HhW0OZC21kc&list=PLQV5mozTHmafsYxB8duQI6r9c5ZTShOEY
 */
class Genereerimine {
    static int empty[][] = new int[9][9];
    static int show[][] = new int[9][9];
    static int solved[][] = new int[9][9];

    static int[][] toSolve(int[][] forUser) {
        //genereerime sudoku m�ngijale
        int[] firstRow = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}; //tulevase maatriksi esimene rida
        shuffleArray(firstRow);//segame numbrid
        for (int i = 0; i < 9; i++) { //t�idame maatriksi esimese rea etteantud numbritega, �lej��nud numbrid t�idame nullidega
            for (int j = 1; j < 9; j++) {
                empty[0][i] = firstRow[i];
                empty[j][i] = 0;
            }//tulemuseks saime maatriksi, mida meetod "sudoku" hakkab lahendama
        }
        int filled[][] = new int[9][9];
        //v�tame etteantud 9x9 maatriksi (forUser1, 2 v�i 3) ja segame v��rtused
        shuffleforUser(forUser);
        //asendame osad lahendatud maatriksi numbrid 0-ga
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (forUser[i][j] == 1) {
                    show[i][j] = 0;
                } else {
                    show[i][j] = sudoku(0, 0, filled)[i][j];
                }
            }
        }
        return show; //tagastame uue maatriksi (kasutame seda abimaatriksina m�nguv�lja genereerimisel)
    }

    static void shuffleArray(int[] ar) {
        //meetod numbrite segamiseks �herealises massiivis
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    static void shuffleforUser(int[][] ar) {
        //meetod numbrite segamiseks 9x9 massiivis
        Random rnd = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int index = rnd.nextInt(9);
                int a = ar[i][index];
                ar[i][index] = ar[i][j];
                ar[i][j] = a;
            }

        }
    }

    public static boolean kontroll(int x, int y, int[][] filled) {
        //sudoku lahendamisel peame kontrollima, et numbrid ei kordu reas, veerus ja ruudus 3x3
        String temp = "";
        for (int i = 0; i < 9; i++) {
            //loeme rea ja veeru numbrid, kirjutame �les
            temp += Integer.toString(filled[i][y]);
            temp += Integer.toString(filled[x][i]);
            //loeme 3x3 ruudu  numbrid, kirjutame �les
            temp += Integer.toString(filled[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3]);
        }
        int count = 0, idx = 0; //kontrollime kas numbrid korduvad?
        while ((idx = temp.indexOf(Integer.toString(filled[x][y]), idx)) != -1) {//kas v��rtused on samad?
            idx++;
            count++;
        } //kui v��rtused korduvad meetod tagastab "false", kui ei kordu  - "true"
        return count == 3;
    }

    public static int[][] sudoku(int y, int x, int[][] filled) {
        //lahendame empty maatriksi
        while (!kontroll(8, 8, filled) || filled[8][8] == 0) { //kuni sudoku ei ole lahendatud, j�tkame ts�kli
            if (empty[y][x] != 0) { //kui empty maatriksi v��rtus ei ole null
                filled[y][x] = empty[y][x];//siis kopeerime v��rtust
                int yy, xx;
                if (x == 8) { //kui oleme rea l�pus
                    yy = y + 1; //siis l�heme j�rgmisele reale
                    xx = 0;
                } else { //vastasel juhul
                    yy = y;// liigume edasi samas reas
                    xx = x + 1;
                }
                sudoku(yy, xx, filled); //kirjutasime empty maatriksi etteantud numbri, k�ivitame meetodit uuesti
            } else { //kuui j�udsime nullideni, hakkame lahendama
                if (filled[y][x] < 9) { //kui number on 9 v�iksem
                    filled[y][x]++; //suurendame �he v�rra
                    //kontrollime, et numbrid ei korduks
                    if (kontroll(y, x, filled)) { //kui tingimus on t�idetud, liigume edasi
                        int yy, xx;
                        if (x == 8) {
                            yy = y + 1;
                            xx = 0;
                        } else {
                            yy = y;
                            xx = x + 1;
                        }
                        sudoku(yy, xx, filled); //kui on korras k�ivitame meetodi uuesti
                    }
                } else { //kui ei ole korras, siis kirjutame nulli ja l�heme eelmisesse ts�klisse
                    filled[y][x] = 0;
                    break;
                }
            }
        }
        System.arraycopy(filled, 0, solved, 0, 9);
        return solved; // meetod tagastab uue maatriksi, mida kasutame m�nguv�lja genereerimisel
    }


}




