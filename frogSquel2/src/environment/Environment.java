package environment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import environment.Car;
//import gameCommons.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

import graphicalElements.Element;
import util.Case;

public class Environment implements IEnvironment {
    ArrayList<Lane>way;
    Game game;


    public Environment (Game game) {
        this.game = game;
        this.way= new ArrayList<>();
        this.way.add(new Lane(game,0,0.0));

        for (int i = 1; i< game.height-1; i++){
            this.way.add(new Lane(game,i,0.2));
        }
       this.way.add(new Lane(game, game.height - 1, 0.0));



    }  //TODO
    public boolean isSafe(Case c){
        return this.way.get(c.ord).isSafe(c);

    }


    @Override
    public void addLane() {


    }

    @Override
    public boolean isWinningPosition(Case c) {

        return c.ord == this.game.height -1;



    }

    @Override
    public void update() {
        for (Lane lane : way){
            lane.update();
       }
    }







}
