package Kontrolltood;

import java.util.ArrayList;

/**
 * Created by agrigorj on 01/12/15.
 */
public class KT1_answer {

    public static void main (String[] args) {
        System.out.println (keskmisestParemaid (new double[]{1,2,3,5,10,12.5}));

    }

    public static int keskmisestParemaid (double[] d) {
        double sum=0;
        double keskm;
        for (int i = 0; i <d.length ; i++) {
            sum= sum+d[i];
        }
        keskm=sum/d.length;
        System.out.println(keskm);
        ArrayList a= new ArrayList();

        for (int i = 0; i < d.length; i++) {
            if (d[i]>keskm) {
                a.add(d[i]);

            }
        }
        return  a.size();

    }  // YOUR PROGRAM HERE
   }


