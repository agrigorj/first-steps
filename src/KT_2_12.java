import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Koostage Java meetod etteantud täisarvumaatriksi m veerumaksimumide
 * massiivi leidmiseks (massiivi j-ndaks elemendiks on maatriksi j-nda veeru suurima elemendi väärtus).
 * Arvestage, et m read võivad olla erineva pikkusega.
 * Created by agrigorj on 01/12/15.
 */
public class KT_2_12 {

    public static void main(String[] args) {
        int[] res = veeruMinid(new int[][]{{1,2,6}, {4, 5, 3}}); // {5, 7, 9}
        System.out.println(Arrays.toString(res));
        // YOUR TESTS HERE
    }

    public static int[] veeruMinid(int[][] m) {
        int size=m.length, largestRow=0, col=0, l=0;
        //System.out.println(size);
        for (int check=0;check<size;check++) {
            if (largestRow<m[check].length){
                largestRow=m[check].length;
                l=check;

            }
        }

        int [] vastus=new int[largestRow];

        do {

            for (int row = 0; row < m.length; row++) {
                int sum=m[l][col];
                for (int i = 0; i <m.length ; i++) {
                    if (col >= (m[i].length)) {
                    } else if(m[i][col]>= sum){
                        sum = m[i][col];
                        vastus[col]=sum;

                }

                }
            }
            col += 1;

        }while (col!=largestRow);

        // TODO!!!    YOUR PROGRAM HERE
        return vastus;
    }

}

