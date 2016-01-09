/**
 * Created by agrigorj on 01/12/15.
 */
public class harjutus {
    public static void testArray() {
        int myArray[] = {3,5,7,12};
        int sum=0;
        for(int i=0; i<myArray.length; i++) {
            sum=sum+myArray[i];
        }
        System.out.println(sum);
    }
}
