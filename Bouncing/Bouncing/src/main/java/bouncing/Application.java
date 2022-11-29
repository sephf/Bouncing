/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing;

import bouncing.presentation.Controller;
import bouncing.presentation.Model;
import bouncing.presentation.View;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        window = new JFrame();

        Model model= new Model();
        View view = new View();
        Controller controller =new Controller(model,view);
        window.setSize(615,335);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Bouncing");
        try {
            window.setIconImage((new ImageIcon(Application.class.getResource("/bola+estadium+football+game+goal+soccer+icon-1320086004814353114.png"))).getImage());
        } catch (Exception e) {}
        window.setContentPane(view.getPanel());
        window.setVisible(true);
    }

    public static JFrame window;

        
}
