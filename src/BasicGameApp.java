import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class BasicGameApp implements Runnable, KeyListener, MouseListener {

    final int WIDTH = 1000;
    final int HEIGHT = 700;
    public boolean gameOver;


    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;
    public Image GeoMan;
    public Image GeoBackground;
    public Image GeoBase;
    public Image obstacle;
    public int speed = 15;

    private GeoMan GeoMan1;
    public Obstacle[] obstacles = new Obstacle[3];


    public static void main(String[] args) {
        BasicGameApp myGame = new BasicGameApp();
        new Thread(myGame).start();
    }

    public BasicGameApp(){
        setUpGraphics();
        GeoMan = Toolkit.getDefaultToolkit().getImage("GeoMan.png");
        obstacle = Toolkit.getDefaultToolkit().getImage("obstacle.png");
        GeoMan1= new GeoMan(100,100,GeoMan);
        for (int i = 0; i < 3; i++) {
            obstacles[i] = new Obstacle(i*(int)(Math.random()*500) + 1000,(int)(2*Math.random()) +1);
        }
        GeoBackground = Toolkit.getDefaultToolkit().getImage("GeoBackground.png");
        GeoBase = Toolkit.getDefaultToolkit().getImage("base.png");
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


    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

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



    public void render(){
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0,0,WIDTH, HEIGHT);
        g.drawImage(GeoBackground, 0,0, 1000, 600, null);
        g.drawImage(GeoBase,0,0,1000,700,null);
        g.drawImage(GeoMan,GeoMan1.xpos, GeoMan1.ypos, 70,70,null);
        for (int i = 0; i < obstacles.length; i++) {
            if(obstacles[i].width == 60){
                g.drawImage(obstacle,obstacles[i].xPos,obstacles[i].yPos,obstacles[i].width,obstacles[i].height,null);
            }
            else{
                g.drawImage(obstacle,obstacles[i].xPos,obstacles[i].yPos,obstacles[i].width/2,obstacles[i].height,null);
                g.drawImage(obstacle,obstacles[i].xPos + (obstacles[i].width/2),obstacles[i].yPos,obstacles[i].width/2,obstacles[i].height,null);
            }

        }
        if (gameOver){
            g.setColor(Color.BLACK);
            g.fillRect(0,0,1000,700);
        }







        g.dispose();
        bufferStrategy.show();

    }

    public void moveThings(){
        GeoMan1.move();
        GeoMan1.move2();
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i].move(speed);
        }
    }

    public void checkIntersections(){
        for (int i = 0; i < obstacles.length; i++) {
            if(GeoMan1.rec.intersects(obstacles[i].rec)){
                gameOver = true;
            }
        }
    }









    public void keyTyped(KeyEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
        //This method will do something whenever any key is pressed down.
        //Put if( ) statements here
        char key = event.getKeyChar();     //gets the character of the key pressed
        int keyCode = event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
        System.out.println("Key Pressed: " + key + "  Code: " + keyCode);

//        if (keyCode == 68) {
//            GeoMan1.right = true;
//        }
//        if (keyCode == 83) {
//            GeoMan1.down = true;
//        }
//        if (keyCode == 65)
//            GeoMmman1.left = true;
//        if (keyCode == 87){
//            GeoMan1.up = true;
//        }
        if (keyCode == 32){
            if(GeoMan1.canJump){
                GeoMan1.dy= -15;
            }


        }
    }



    public void keyReleased(KeyEvent event) {
        char key = event.getKeyChar();
        int keyCode = event.getKeyCode();

        if (keyCode == 32) {
//            if (GeoMan1.ypos >= 530-GeoMan1.height){
//                GeoMan1.dy  = 0;
//            }else {
//                GeoMan1.dy = 5;
//            }
            System.out.println(GeoMan1.ypos + " DY " +GeoMan1.dy);

        }

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


    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }



}