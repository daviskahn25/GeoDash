import java.awt.*;
public class Obstacle {
    public int xPos;

    public Rectangle rec;
    public int width;
    public int height;
    public int yPos = 505;
    public Obstacle(int pxPos, int plength){
        xPos = pxPos;
        width = 150;
        height = 100;
    }
    public void move(int speed){
        xPos = xPos-speed;
        if(xPos<-200){
            xPos = (int)(1000*Math.random())+1000;
        }
        rec = new Rectangle(xPos, yPos, width, height);
    }
}
