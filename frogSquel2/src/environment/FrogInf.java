package environment;
import environment.EnvInf;

import frog.Frog;
import gameCommons.Game;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Case;
import util.Direction;

import javax.swing.text.Position;
import java.awt.*;

public class FrogInf extends Frog implements IFrog {


    public FrogInf (Game game){
        super(game);
        this.dir = super.getDirection();
        this.pos = super.getPosition();

    }



 /* public void setScore(Direction key){
        if(key == Direction.up){
           score++;
        }
  }



  public int getScore(){
        return this.score;
  }*/

   /** public int setScore () {
        int pos;
        int score = 0 ;

        if(this.pos.ord <= 1){
            score = 1;
        }
        if (this.pos.ord > score){
            score = this.pos.ord;
        }
        return score;
    }**/




   public void move(Direction key) {
       this.dir = key;
       if (this.pos.ord == 0){
           this.game.score = -1;
       }
        if (key == Direction.up) {
            this.pos= new Case(this.pos.absc, this.pos.ord + 1);
            ++this.game.score;
            if (this.game.score > this.game.maxScore) {
                this.game.maxScore = this.game.score;
                System.out.println( "ok1");
                this.game.addLane ();
                System.out.println( "ok2");
            }
        }

        if (key == Direction.down && this.pos.ord > 0) {
            this.pos= new Case(this.pos.absc, this.pos.ord - 1);
            --this.game.score;
        }

        if (key == Direction.right && this.pos.absc < this.game.width - 1) {
            this.pos = new Case(this.pos.absc + 1, this.pos.ord);
        }

        if (key == Direction.left && this.pos.absc > 0) {
            this.pos = new Case(this.pos.absc - 1, this.pos.ord);
        }
       this.game.getGraphic().add(new Element(this.pos.absc, 1, Color.GREEN));
       this.game.testWin();
       this.game.testLose();


        System.out.println(this.pos.absc + " " + this.pos.ord + " score : " + this.game.score);
    }


    /*public Case getPosition (Case c){
        return super.getPosition();
    }*/
    @Override
    public Case getPosition() {
        return super.getPosition();
    }

    @Override
    public Direction getDirection() {
        return super.getDirection();
    }









    }


