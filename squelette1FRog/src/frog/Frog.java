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
		if(key == Direction.up){
			if( getPosition().ord != game.height-1) {
				this.pos = new Case(getPosition().absc, getPosition().ord + 1);
			}

		}
		if(key == Direction.down){
			if( getPosition().ord != 0) {
				this.pos = new Case(getPosition().absc, getPosition().ord + -1);
			}

		}
		if(key == Direction.right){
			if(getPosition().absc != game.width-1 ) {
				this.pos = new Case(getPosition().absc + 1, getPosition().ord);
			}
		}
		if(key == Direction.left){
			if(getPosition().absc != 0 ) {
				this.pos = new Case(getPosition().absc - 1, getPosition().ord);
			}
		}

	}


}
