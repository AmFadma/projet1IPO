package gameCommons;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.util.Random;
import java.util.TimerTask;


import environment.EnvInf;
import environment.FrogInf;
import environment.Lane;
import frog.Frog;
import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import util.Direction;



public class Game {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;
	public int score = 0;
	public int maxScore = 0;
	private ActionListener tache_timer;
	public Timer timer = new Timer(1000,tache_timer);
	public int secondPassed ;
	public String tm;

	// Lien aux objets utilis�s
	private IEnvironment environment;
	private IFrog frog;
	private IFroggerGraphics graphic;
	private Main m;
	private Main timer1;

	/**
	 * @param graphic             l'interface graphique
	 * @param width               largeur en cases
	 * @param height              hauteur en cases
	 * @param minSpeedInTimerLoop Vitesse minimale, en nombre de tour de timer avant d�placement
	 * @param defaultDensity      densite de voiture utilisee par defaut pour les routes
	 */
	public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;

		graphic.setGame(this);

		this.play();



	}

	/**
	 * Lie l'objet frog � la partie
	 *
	 * @param frog
	 */
	public void setFrogInf(IFrog frog) {
		this.frog = frog;
	}

	/**
	 * Lie l'objet environment a la partie
	 *
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		if (!(this.environment.isWinningPosition(this.frog.getPosition()))) {
			if (!(this.environment.isSafe(this.frog.getPosition()))) {



				this.graphic.endGameScreen(" score of "+ this.maxScore +", timer in terminal");



				//this.graphic.endGameScreen("   ");

			}
			return true;

		}

		return false;
	}


	/**
	 * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si la partie est gagn�e
	 */
	public boolean testWin() {

		if (this.environment.isWinningPosition(this.frog.getPosition())) {
			this.graphic.endGameScreen("you win");
			return true;

		}else {
			return false;
		}
	}

	/**public void afficheWay(){
		System.out.println(t);
	}**/
	public void play(){
		//Cr�ation et liason de la grenouille
		IFrog frog = new Frog(this); //suppose qu'il y a un param de type game
		//game.setFrog(frog);
		//graphic.setFrog(frog);
		//IFrog frog = new FrogInf(game); //suppose qu'il y a un param de type game
		this.setFrogInf(frog);
		graphic.setFrog(frog);
		//score = 0;

	}
	 public String tim (String t){
		return t;
	 }






	/**TimerTask task = new TimerTask() {


		public void run() {
			secondPassed ++;
			System.out.println( "Second passed: " + secondPassed);
		}
	};

	/*public void starteu(){
		this.timer.scheduleAtFixedRate(task, 0, 1000);

	}*/



	/**public Timer getTimer() {
		timer.
		return timer;
	}**/

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */

	public void update() {



		graphic.clear();
		environment.update();
		this.graphic.add(new Element(frog.getPosition(), Color.GREEN));
		testLose();
		testWin();





	}

	public void addLane() {
		this.environment.addLane();
	}

	/*public Timer setTimer () {
		return this.timer ;
	}*/



}



