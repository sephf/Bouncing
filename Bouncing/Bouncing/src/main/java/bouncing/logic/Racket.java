package bouncing.logic;

import java.awt.Rectangle;

public class Racket {
    public int x;
    public int y;
    public static final int W=50;
    public static final int H=10;     
    
    public int dx;
    public int dy;    

    public Racket(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
    }   
    
    public void move(Rectangle b){    
        if ((x + dx < b.x) || (x + W+ dx > b.x+b.width))
          dx = 0;
        if ((y + dy < b.y) || (y + H + dy > b.y+b.height))
          dy = 0;

        x += dx;
        y += dy;          
    }
    
   public static final int IZQ=-3;
   public static final int DER=3;
   public static final int ARR=-2;
   public static final int ABA=2;
    
}
