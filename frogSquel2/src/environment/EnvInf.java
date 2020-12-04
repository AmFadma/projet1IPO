package environment;

import environment.FrogInf;
import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;
import util.Direction;

import java.util.ArrayList;

public class EnvInf extends Environment implements IEnvironment {
    public EnvInf(Game game) {
        super(game);
        this.way= new ArrayList();
        this.way.add(new Lane(game, 0, 0.0D));

        for(int i = 1; i < game.height; ++i) {
            this.addLane(i);
        }
    }
    public void addLane (int i){
       this.way.add(new Lane(game,i,0.2));
    }
   // public void addLane(int i) {
       // this.way.add(new Lane(this.game, i, 0.2));
    //}
  public void moveLanes (Direction key){

        Lane lane ;
        if (key == Direction.up){

            for( int i = 2; i<game.height;i++){
                lane = this.way.get(i);
                lane.newOrd();
            }

            addLane(game.height);
        }

        update();


    }



    @Override
    public boolean isSafe(Case c) {
        return super.isSafe(c);
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return super.isWinningPosition(c);
    }


    public void removeOldLane(int i){
        this.way.remove(i);
    }




    @Override
    public void update() {
        super.update();







    }

    private void moveLanes() {
    }

    public void addLane() {
        this.addLane(this.way.size());
    }




}










