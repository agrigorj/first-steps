import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by agrigorj on 28/12/15.
 */
public class ElapsedT extends GUI {
   static int secondsPassed =0;
    static Timer myTimer= new Timer();
    static TimerTask task;
    static int minutePassed;
    static  int hoursPassed;
    static String time;


        public void startCount() {
            secondsPassed=0;
            if (task != null)
                return;
            task = new TimerTask() {
                @Override
                public void run() {
                    secondsPassed++;
                    if (secondsPassed == 60) {
                        secondsPassed = 0;
                        minutePassed++;
                    }
                    if (minutePassed == 60) {
                        minutePassed = 0;
                        hoursPassed++;
                    }
                    String seconds = Integer.toString(secondsPassed);
                    String minutes = Integer.toString(minutePassed);
                    String hours = Integer.toString(hoursPassed);

                    if (secondsPassed <= 9) {
                        seconds = "0" + Integer.toString(secondsPassed);
                    }
                    if (minutePassed <= 9) {
                        minutes = "0" + Integer.toString(minutePassed);
                    }
                    if (hoursPassed <= 9) {
                        hours = "0" + Integer.toString(hoursPassed);
                    }


                    time = (hours+":"+minutes+":"+seconds);
                    getTime();

                    }

            };
            myTimer.scheduleAtFixedRate(task, 0, 1000);

        }

    public String  getTime() {
        String show = time;
        return show;


    }

    public void stopCount() {
        if(task==null)
            return;
        task.cancel();
        task=null;

    }

    }

