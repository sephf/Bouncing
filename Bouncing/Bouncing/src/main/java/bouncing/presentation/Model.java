package bouncing.presentation;

import bouncing.logic.Ball;
import bouncing.logic.Racket;
import java.awt.Rectangle;
import java.util.Observable;

public class Model extends Observable{
    Rectangle bounds;
    Ball b;
    Ball b2;
    Racket r;
    
    public Model() {
        bounds= new Rectangle(50,50,500,200);
        b= new Ball(100,150,32,Ball.DER,Ball.ARR);
        r=new Racket(bounds.x+(bounds.width/2),bounds.y+bounds.height-Racket.H-5);
        b2= new Ball(190,200,32,Ball.DER,Ball.ARR);
    }

    public void step(){
        b.move(bounds,r);
        b2.move(bounds,r);
        r.move(bounds);
    }
    
    public void move(int flecha){
       switch(flecha){
           case ARR: 
               r.dy=Racket.ARR;
               break;
           case ABA:
               r.dy=Racket.ABA;
               break;
           case IZQ:
               r.dx=Racket.IZQ;
               break;
           case DER:
               r.dx=Racket.DER;
               break;               
       }        
    }

    public void stop(int flecha){
        switch(flecha){
            case ARR: case ABA:
                r.dy=0;
                break;

            case IZQ:  case DER:
                r.dx=0;
                break;
        }
    }

    public void commit(){
        this.setChanged();
        this.notifyObservers();        
    }  
    
   public static final int ARR=1;
   public static final int ABA=2;
   public static final int DER=3;   
   public static final int IZQ=4;      
}











