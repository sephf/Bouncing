package bouncing.logic;

import java.awt.Rectangle;

public class Ball {
    public int x;
    public int y;
    public int r;  
    public int dx;
    public int dy;

    public boolean collision=false;

    public Ball(int x, int y, int r, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.r=r;
        this.dx = dx;
        this.dy = dy;
    }
    
    public void move(Rectangle bounds, Racket racket){
        x += dx;
        y += dy;  
        
        if ((x - r  < bounds.x) || (x + r > bounds.x+bounds.width))
          dx = -dx;
        if ((y - r < bounds.y) || (y + r > bounds.y + bounds.height))
          dy = -dy;

        if ( (racket.x< x+r && x-r<racket.x+racket.W) && (y + r > racket.y)) {
            dy = ARR;
            collision=true;
        }
    }    

   public static final int IZQ=-2;
   public static final int DER=2;
   public static final int ARR=-2;
   public static final int ABA=2;    
   
}