import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class BasicGameApp implements Runnable, KeyListener, MouseListener {

    final int WIDTH = 1000;
    final int HEIGHT = 700;


    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;


    public static void main(String[] args) {
        BasicGameApp myGame = new BasicGameApp();
        new Thread(myGame).start();
    }

    public BasicGameApp(){
        setUpGraphics();
        canvas.addKeyListener(this);
        canvas.addMouseListener(this);
    }

    public void run (){
        while(true){
            moveThings();
            checkIntersections();
            render();
            pause(20);
        }
    }
    public void render(){
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0,0,WIDTH, HEIGHT);





        g.dispose();
        bufferStrategy.show();

    }

    public void moveThings(){

    }

    public void checkIntersections(){

    }









    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }


    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }

    public void setUpGraphics() {
        frame = new JFrame("CheeseWorld");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }



}
