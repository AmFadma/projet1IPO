package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	public Game game;
	public Direction dir;
	public Case pos;

	public Frog(Game game) {
		this.game = game;
		this.dir = Direction.up;
		this.pos = new Case(game.width / 2, 0);
	}
	public Case getPosition (){
		return this.pos;


	}

	@Override
	public Direction getDirection() {
		return this.dir;
	}

	@Override
	public void move(Direction key) {

		if(key == Direction.up && getPosition().ord != game.height-1){

				this.pos = new Case(getPosition().absc, getPosition().ord + 1);
				++this.game.score;
				if (this.game.score > this.game.maxScore) {
					this.game.maxScore = this.game.score;
					System.out.println( "ok1");
					this.game.addLane ();
					System.out.println( "ok2");
				}


		}
		if(key == Direction.down){
			if( getPosition().ord > 0) {
				this.pos = new Case(getPosition().absc, getPosition().ord + -1);
				--this.game.score;
			}

		}
		if(key == Direction.right && getPosition().absc < game.width-1){

				this.pos = new Case(getPosition().absc + 1, getPosition().ord);


		}
		if(key == Direction.left && getPosition().absc > 0 ){

				this.pos = new Case(getPosition().absc - 1, getPosition().ord);


		}
		System.out.println(this.pos.absc + " " + this.pos.ord + " score : " + this.game.score);
		game.testWin();
		game.testLose();



	}


}
