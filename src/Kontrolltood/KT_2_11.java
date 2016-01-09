package Kontrolltood;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

/**Sportlase punktisumma arvutatakse üksikkatsetest saadud punktide summana, millest on maha
 * võetud kahe halvima katse tulemused (üksikkatseid on rohkem kui kaks).
 Kirjutada Java meetod, mis arvutab punktisumma üksikkatsete tulemuste massiivi põhjal.
 Parameetriks olevat massiivi muuta ei tohi.
 * Created by agrigorj on 01/12/15.
 */
public class KT_2_11 {

    public static void main (String[] args) {
        System.out.println(result(new double[]{0., 1., 2., 3., 4.})); // 9
        // Your tests here
    }
    /**public static int score(int[] marks) {
        int marksCopy[]=new int[marks.length];
        System.arraycopy(marks,0,marksCopy,0,marks.length);
        Arrays.sort(marksCopy);
        int sum=0;
        for (int i = 0; i < marksCopy.length; i++) {
            sum=sum+marksCopy[i];

        }
        return (sum-marksCopy[0]-marksCopy[1]); // TODO!!! Your program here
    }
}*/

    public static double result (double[] marks) {
        double sum=0;
        double max=marks[0];
        double min=marks[0];
        for (int i = 0; i <marks.length ; i++) {
            if(marks[i]>max){
                max=marks[i];
            }else if(marks[i]<min){
                min=marks[i];
            }
            sum=sum+marks[i];


        }
        double vastus=(sum-max-min)/(marks.length-2);


        return (vastus); // TODO!!! Your program here
    }
}
