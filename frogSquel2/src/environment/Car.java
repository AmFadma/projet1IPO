package environment;

import java.awt.Color;

//import gameCommons.Case;
import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game game, Case firstCase, boolean leftToRight) {

		this.game = game;
		this.leftToRight =leftToRight;
		this.length = game.randomGen.nextInt(2)+1;//à changer
        if (this.leftToRight) {
            this.leftPosition = new Case(firstCase.absc - this.length, firstCase.ord);
        } else {
            this.leftPosition = new Case(firstCase.absc, firstCase.ord );
        }

	}

	//TODO : ajout de methodes

	/**public Case position (boolean leftToRight, Case firstCase) {
		if (leftToRight) {
			leftPosition = new Case(0, firstCase.ord);
		} else {
			leftPosition = new Case(game.width,leftPosition.ord );
		}
		return leftPosition;
	}**/




	public void move(boolean b) {
		if(b){
			if (leftToRight)
			leftPosition = new Case(this.leftPosition.absc + 1, this.leftPosition.ord); //ajouterwhile pour move bcp
		else
			leftPosition = new Case(this.leftPosition.absc - 1, this.leftPosition.ord);
		}
		this.addToGraphics();
	}

	/**public Case getPosition () {
		return leftPosition;
	}**/

	public boolean appearsInBounds (){
	    return (this.leftPosition.absc < game.width || this.leftPosition.absc + this.length > 0);

	}





	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

	public boolean coversCase(Case c) {//*****************************************************************************
		if (this.leftPosition.ord != c.ord) {
			return false;
		} else {
			return c.absc >= this.leftPosition.absc && c.absc < this.leftPosition.absc + this.length;
		}
	}

}
