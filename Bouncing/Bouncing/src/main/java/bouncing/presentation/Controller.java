package bouncing.presentation;

public class Controller {
    Model model;
    View view;
    
    Animator animator;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        
        animator = new Animator(this);
        animator.start();
    }

    public void move(int flecha){
        model.move(flecha);
    }

    public void stop(int flecha){
        model.stop(flecha);
    }    

    public void animate(){
        model.step();
        model.commit();
    }
}
