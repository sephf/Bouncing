package bouncing.presentation;

import javax.swing.SwingUtilities;

public class Animator {
    Controller controller;

    public Animator(Controller controller) {
        this.controller = controller;        
    }
    
    private Thread hilo;
    private boolean condition=false;
    public void start(){
        Runnable tarea = new Runnable(){
            public void run(){
                while(condition){ 
                    try { Thread.sleep(7);}
                    catch (InterruptedException ex) {}
                    animate();              
                }
            }
        };
        hilo = new Thread(tarea);
        condition=true;
        hilo.start();        
    }
    public void stop(){
        condition=false;
    }
    private void animate(){
        SwingUtilities.invokeLater(
            new Runnable(){
                public void run(){
                    controller.animate();
                }
             }
        );          
    }        
}
