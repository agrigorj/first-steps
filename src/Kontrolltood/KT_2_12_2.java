package Kontrolltood;

import java.util.Arrays;

/**Koostage Java meetod etteantud täisarvumaatriksi m veerusummade massiivi leidmiseks
 * (massiivi j-s element on maatriksi j-nda veeru summa).
 *  Arvestage, et m read võivad olla erineva pikkusega.
 * Created by agrigorj on 04/12/15.
 */
public class KT_2_12_2 {

    public static void main(String[] args) {
        int[] res = veeruSummad (new int[][] { {1,2},{1,2,3,6}, {4,5,6} }); // {5, 7, 9}
        //System.out.println(Arrays.toString(res));
        // YOUR TESTS HERE
    }

    public static int[] veeruSummad(int[][] m) {
        int size=m.length, largestRow=0, sum=0, col=0;
        for (int check=0;check<=(size-1);check++) {
            if (largestRow<m[check].length){
                largestRow=m[check].length;
            }
        }
        int [] vastus=new int[largestRow];

        do {
            for (int row = 0; row < m.length; row++) {
                if (col >= (m[row].length)) {
                } else {
                    sum += m[row][col];
                    vastus[col]=sum;
                }
            }
            col += 1;

            sum = 0;


        }while (col!=largestRow);
        System.out.println(Arrays.toString(vastus));





            //vastus[0]=m[0][0]+m[1][0];
            //vastus[1]=m[0][1]+m[1][1];
            //vastus[2]=m[0][2]+m[1][2];





        // TODO!!!    YOUR PROGRAM HERE
        return null;
    }

}

