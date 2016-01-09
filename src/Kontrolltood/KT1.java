package Kontrolltood;

/**
 * Created by agrigorj on 01/12/15.
 */
public class KT1 {


    public static void main (String[] args) {
        System.out.println (ruutudeSumma (new int[]{0}));
        // YOUR TESTS HERE
    }

    public static int ruutudeSumma (int[] m) {
         // YOUR PROGRAM HERE
        int sum=9;
        int b=sum++/5;
        for (int i = 0; i < m.length ; i++) {
            sum=sum+Math.abs(m[i]);

            } return b;


        }
    }


