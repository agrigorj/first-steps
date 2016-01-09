package Kontrolltood;

/** Koostada Java meetod, mis asendab parameetrina etteantud sõnes s kõik suurtähed märgiga '_'.
 Lahendus peab kasutama tsüklit.

 Write a Java method to replace all uppercase letters in a given string s by symbol '_'.
 The solution must use a loop.

 public static String asenda (String s)

 * Created by agrigorj on 01/12/15.
 */
public class KT2_9 {

    public static void main (String[] args) {
        String s = "Tere, TUDENG, 1234!";
        String t = asenda (s); // "Tere,-TUDENG,---tore-ARVUTI-sul!"
        System.out.println (s + " > " + t);
    }

    public static String asenda (String s) {
       char ch;
        boolean b1;
        for (int i = 0; i <s.length() ; i++) {
            ch=s.charAt(i);
            if (b1=Character.isLetter(ch)){
                String p =s.replace(ch,'x');
                s = p;

            }

        }
        return  s; // TODO!!! Your code here
    }
}

