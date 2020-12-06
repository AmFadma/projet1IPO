package gameCommons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


import environment.Lane;
import gameCommons.Game;
import gameCommons.Time;
import environment.EnvInf;
import environment.Environment;
import environment.FrogInf;
import frog.Frog;
import givenEnvironment.GivenEnvironment;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;

public class Main {

	private static int heure=0,minute=0,seconde=0;
	private static String t;
	private ArrayList <String> m = new ArrayList<String >();;


	public static void main(String[] args) {

		//Caract�ristiques du jeu
		int width = 26;
		int height = 30;
		int tempo = 100;
		int minSpeedInTimerLoops = 3;
		double defaultDensity = 0.2;



		//Cr�ation de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Cr�ation de la partie
		Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity);
		//Cr�ation et liason de la grenouille
		//IFrog frog = new Frog(game); //suppose qu'il y a un param de type game
		//game.setFrog(frog);
		//graphic.setFrog(frog);
		IFrog frog = new FrogInf(game); //suppose qu'il y a un param de type game
		game.setFrogInf(frog);
		graphic.setFrog(frog);
		//Cr�ation et liaison de l'environnement
		//IEnvironment env = new GivenEnvironment(game);
		//IEnvironment env = new Environment(game);
		IEnvironment env = new EnvInf(game);
		game.setEnvironment(env);
		for(int i = 0; i < 4*width; ++i) {//****************************************************
			game.update();
		}


		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				game.update();
				graphic.repaint();

			}
		});
		timer.setInitialDelay(0);
		timer.start();


		/* Action réalisé par le timer */
		int delais=1000;
		ArrayList <String> m = new ArrayList<String >();
		final int[] i = {0};




		ActionListener tache_timer= new ActionListener() {
			public void actionPerformed(ActionEvent e1)
			{

					seconde++;
					if (seconde == 60) {
						seconde = 0;
						minute++;
					}
					if (minute == 60) {
						minute = 0;
						heure++;
					}


					t=(heure + ":" + minute + ":" + seconde);
					if (!env.isSafe(frog.getPosition())) {


						m.add(i[0], t);
						i[0]++;
						System.out.println("Timer: "+ m.get(0));
						game.tm = m.get(0);
						System.out.println("Timer2: "+ game.tm);
						//graphic.endGameScreen(" score of " + game.maxScore + " in " +  m.get(0));
					}



				//System.out.println(heure + ":" + minute + ":" + seconde);

				//graphic.endGameScreen(" score of " + game.maxScore + " in " + m[0]);

					//for (String string : m){

					//}
				//game.tm = m.get(0);++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				//System.out.println("Timer3: "+ game.tm);++++++++++++++++++++++++++++++++++++++


				}


		};
		Timer timer1= new Timer(delais,tache_timer);
		timer1.start();
		timer1.stop();




			//System.out.println("kk" + game.tm);
			timer1.restart();




		//if (!env.isSafe(frog.getPosition())) {
		//timer1.stop();

		//System.out.println(game.tm);
	   //}
			//game.graphic.endGameScreen( heure + ":" + minute + ":" + seconde);
			//graphic.endGameScreen(" score of "+ game.maxScore +" in "+t);**/



		}





}





