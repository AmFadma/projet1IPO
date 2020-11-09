package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;

	private Direction dir;
	private Case pos;

	public Frog(Game game) {
		this.game = game;
		this.dir = Direction.up;
		this.pos = new Case(game.width / 2, 0);
	}
	public Case getPosition (){
		return this.pos;


	}




}
