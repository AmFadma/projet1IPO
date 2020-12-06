package environment;

import environment.FrogInf;
import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;
import util.Direction;

import java.util.ArrayList;
import java.util.Iterator;

public class EnvInf extends Environment implements IEnvironment {

    public EnvInf(Game game) {
        super(game);
        this.way= new ArrayList();
        this.way.add(new Lane(game, 0, 0.0D));
        this.way.add(new Lane(game, 1, 0.0D));

        for(int i = 2; i < game.height; ++i) {
            this.addLane(i);
        }
    }
    public void addLane (int i){
       this.way.add(new Lane(game,i,0.2));
    }

   /*public void updateLanes(Case c){
        for (Lane lane : way) {
            if (way.get(c.ord) == way.get(2)){
                lane = way.get(c.ord - 2);
                way.remove(c.ord - 2);






            }
        }

    }*/





    @Override
    public boolean isSafe(Case c) {
        return super.isSafe(c);


    }
    public boolean appearsInBounds (Case c){
        return (c.ord< game.height || c.ord> 0);

    }

    @Override
    public boolean isWinningPosition(Case c) {
        return false;
    }


    public void removeOldLane(int i){
        this.way.remove(i);
    }




    @Override
    public void update() {
        super.update();







    }



    public void addLane() {
        this.addLane(this.way.size());

    }




}










