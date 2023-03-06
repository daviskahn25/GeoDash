import java.awt.*;

public class GeoMan {

    public int xpos;
    public int ypos;
    public int width;
    public int height;
    public boolean isAlive;
    public int dx;
    public int dy;
    public Rectangle rec;
    public Image pic;

    public boolean right;
    public boolean down;
    public boolean left;
    public boolean up;


    public GeoMan(int dxParameter, int dyParameter, Image picParameter){
        xpos = 20;
        ypos = 530;
        width = 50;
        height = 50;
        dx = 5;
        dy = 0;
        pic = picParameter;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);
    }

    public void move (){
        xpos = xpos + dx;
        ypos = ypos + dy;
    }

    public void bounce(){
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (xpos >= 1000-width ||xpos<=0  ){//right or left wall
            dx = -dx;}

        if (ypos<=0 || ypos>=700-height){//top or bottom wall
            dy = -dy;}

        rec = new Rectangle(xpos,ypos, width, height);
    }

    public void wrap (){
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (xpos>=1000-width && dx>0) {//right wall
            xpos = -width;
        }

        if (xpos <= -width && dx<0){//left wall
            xpos = 1000;
        }

        if (ypos <= -height && dy<0){//top wall
            ypos = 700;
        }

        if (ypos>=600 && dy>0){//bottom wall
            ypos = -height;
        }
        rec = new Rectangle(xpos,ypos, width, height);

    }









}
