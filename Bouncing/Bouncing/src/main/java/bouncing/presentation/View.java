package bouncing.presentation;

import bouncing.Application;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    Model model;
    Controller controller;

    BufferedImage bf;
    private JPanel panel;

    public View() {
        loadMedia();
        panel.setSize(600, 300);
        panel.setFocusable(true);
        bf = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                View.this.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                View.this.keyReleased(e);
            }
        });
    }

    public void setModel(Model model) {
        background=background.getScaledInstance(model.bounds.width,model.bounds.height,Image.SCALE_SMOOTH);
        this.model = model;
        model.addObserver(this);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JPanel getPanel() {
        return panel;
    }

    private void keyPressed(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                controller.move(Model.ARR);
                break;
            case KeyEvent.VK_DOWN:
                controller.move(Model.ABA);
                break;
            case KeyEvent.VK_LEFT:
                controller.move(Model.IZQ);
                break;
            case KeyEvent.VK_RIGHT:
                controller.move(Model.DER);
                break;
        }
    }

    private void keyReleased(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyCode();
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                controller.stop(Model.ARR);
                break;
            case KeyEvent.VK_DOWN:
                controller.stop(Model.ABA);
                break;
            case KeyEvent.VK_LEFT:
                controller.stop(Model.IZQ);
                break;
            case KeyEvent.VK_RIGHT:
                controller.stop(Model.DER);
                break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Graphics g = panel.getGraphics();
        if(g!=null) panel.paint(g);
    }

    private void createUIComponents() {
        panel = new JPanel() {
            public void paint(Graphics graphics) {
                Graphics g = bf.getGraphics();

                super.paint(g);
                g.setColor(Color.black);
                g.drawRect(model.bounds.x, model.bounds.y, model.bounds.width, model.bounds.height);
                g.setColor(Color.red);
//                g.fillOval(model.b.x - model.b.r, model.b.y - model.b.r, model.b.r * 2, model.b.r * 2);
                g.drawImage(background,model.bounds.x,model.bounds.y,null);
                g.drawImage(ballImage,model.b.x - model.b.r, model.b.y - model.b.r,null);
                g.drawImage(ballImage2,model.b2.x-model.b2.r,model.b2.y-model.b2.r,null);
                g.setColor(Color.white);
                g.fillRect(model.r.x, model.r.y, model.r.W, model.r.H);
                graphics.drawImage(bf, 0, 0, null);
                if(model.b.collision){
                    ballSound.setFramePosition(0);
                    ballSound.start();
                    model.b.collision=false;
                }
                if(model.b2.collision){
                    ballSound.setFramePosition(0);
                    ballSound.start();
                    model.b2.collision=false;
                }
            }
        };
    }

    Image ballImage;
    Image ballImage2;
    Image background;
    Clip ballSound;
    private void loadMedia() {
        try {
            ballImage = ImageIO.read(Application.class.getResourceAsStream("/bola+estadium+football+game+goal+soccer+icon-1320086004814353114.png"));
            ballImage2=ImageIO.read(Application.class.getResourceAsStream("/ball.png"));
            background = ImageIO.read(Application.class.getResourceAsStream("/descarga.jpg"));
            AudioInputStream audioIn;
            audioIn = AudioSystem.getAudioInputStream(Application.class.getResourceAsStream("/sound.wav"));
            ballSound = AudioSystem.getClip();
            ballSound.open(audioIn);
        } catch (Exception e) {}
    }

}
