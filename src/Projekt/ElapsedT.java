package Projekt;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by agrigorj on 28/12/15.
 * Klass taimeri k�ivitamiseks
 */
class ElapsedT extends GUI {
    int secondsPassed;//sekundid
    Timer myTimer = new Timer();
    TimerTask task;
    int minutePassed;//minutid
    int hoursPassed;//tunnid
    String time;//siia kirjutame aeg formaadis 00:00:00

    public void startCount() {
        //meetodi k�ivitamisel nullime tunnid, minutid, sekundid:
        secondsPassed = 0;
        minutePassed = 0;
        hoursPassed = 0;
        if (task != null)
            return;
        task = new TimerTask() {
            @Override
            public void run() {//aeg l�ks!
                secondsPassed++; //loeme sekundid
                if (secondsPassed == 60) {//kui on l�binud 60 sek, nullime muutujat
                    secondsPassed = 0;
                    minutePassed++;//kui on l�binud 60 sek, suurendame minutid 1 v�rra
                }
                if (minutePassed == 60) {//kui on l�binud 60 min, nullime muutujat
                    minutePassed = 0;
                    hoursPassed++;//kui on l�binud 60 min, suurendame tunnid 1 v�rra
                }
                //kirjutame aeg �les
                String seconds = Integer.toString(secondsPassed);
                String minutes = Integer.toString(minutePassed);
                String hours = Integer.toString(hoursPassed);

                if (secondsPassed <= 9) {
                    //kuni 10 kirjutame 0 ette
                    seconds = "0" + Integer.toString(secondsPassed);
                }
                if (minutePassed <= 9) {
                    //kuni 10 kirjutame 0 ette
                    minutes = "0" + Integer.toString(minutePassed);
                }
                if (hoursPassed <= 9) {
                    //kuni 10 kirjutame null ettte
                    hours = "0" + Integer.toString(hoursPassed);
                }


                time = (hours + ":" + minutes + ":" + seconds);//aeg formaadis 00:00:00
                getTime();//edastame aeg meetodile getTime

            }

        };
        myTimer.scheduleAtFixedRate(task, 0, 1000);//timer k�ivitub kohe ja t��tab sekundite t�psusega

    }

    public String getTime() {
        //meetod tagastab teksti, mida kasutame GUI klassis
        String show = time;
        return show;
    }

    public void stopCount() {
        //timer seisma
        if (task == null)
            return;
        task.cancel();
        task = null;

    }

}

