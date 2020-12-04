package environment;
import environment.Environment;
import environment.Car;
import java.util.ArrayList;
import util.Case;

import gameCommons.Game;
import util.Direction;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars;
	private boolean leftToRight;
	private double density;
	private int timer; //**************************************************************************************************************


	public Lane(Game game, int ord, double density) {
			this.game = game;
			this.ord = ord;
			this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops + 3);//a modifier pour ajouter tictac
			this.cars = new ArrayList<>();
			this.leftToRight = game.randomGen.nextBoolean();
			this.density = density;


			for (int i = 0; i <  3*game.width; ++i) { //**************************************************************************************************
				this.moveCars(true);
				this.mayAddCar();
			}


		}
		// TODO : Constructeur(s


		// TODO

		// Toutes les voitures se déplacent d'une case au bout d'un nombre "tic
		// d'horloge" égal à leur vitesse
		// Notez que cette méthode est appelée à chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut être ajoutée






	 /**public void update() {  //***********************************************************************************************
	  this.timer++;
	  for(Car car : cars) {
	   if (this.timer <= this.speed) {
	    this.moveCars(false);

	   }
	   else {
	    this.moveCars(true);
	    this.mayAddCar();
	    this.timer = 0;
	   }
	  }
	}**/


	public void update() {  //***********************************************************************************************

		  if (this.timer > this.speed) {
			  this.timer = 0;
			  this.moveCars(true);
			  this.mayAddCar();



		   } else {
			  this.moveCars(false);
		   }

		this.timer++;


	}


	private void moveCars(boolean b) {
		for (Car car : this.cars) {
			car.move(b);

		}
		this.removeOldCars();


	}




	// TODO : ajout de methodes

	public boolean isSafe(Case c){

		for (Car car : this.cars) {
			if (car.coversCase(c)) {//************************************************
				return false;
			}
		}
		return true ;
	}



	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au début de la voie avec probabilité égale à la
	 * densité, si la première case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else {
			return new Case(game.width - 1, ord);
		}
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

	private void removeOldCars(){

		this.cars.removeIf(car -> !car.appearsInBounds());



	}


	public String toString() {
		return "Lane [ord=" + this.ord + ", cars=" + this.cars + "]";
	}

	public int newOrd (){
		return this.ord = this.ord-1;
	}



}






/**public boolean getCar (Case c) {
    Car car = cars.get(c.ord);
    if (cars.get(c.absc)))

    if (.equals(c);


}**/








