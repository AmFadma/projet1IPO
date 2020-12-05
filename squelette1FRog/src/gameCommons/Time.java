package gameCommons;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
    public Game game;
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
        }
    }


