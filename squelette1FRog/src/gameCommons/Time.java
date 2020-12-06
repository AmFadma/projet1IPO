package gameCommons;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class Time {
    /**public Game game;
    public int secondPassed;
    public Timer myTimer;

    public Time (Game game) {
        this.game = game;
        this.myTimer = new Timer();
    }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                secondPassed ++;
                System.out.println( "Second passed: " + secondPassed);
            }

        };

        public void start(){
            myTimer.scheduleAtFixedRate(task, 1000, 1000);
        }

        public void update (){
          start();
        }**/
    private static int heure=0,minute=0,seconde=0;



        /* Le timer */
    /**int delais=1000;
        ActionListener tache_timer;

        /* Action réalisé par le timer */
        /**tache_timer= new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                seconde++;
                if(seconde==60)
                {
                    seconde=0;
                    minute++;
                }
                if(minute==60)
                {
                    minute=0;
                    heure++;
                }
                System.out.println(heure+":"+minute+":"+seconde);
            }
        };

        /* instanciation du timer */
       /** final javax.swing.Timer timer1= new Timer(delais,tache_timer);
        timer1.start();**/

}




