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
        ypos = 20;
        width = 50;
        height = 50;
        dx = dxParameter;
        dy = dyParameter;
        pic = picParameter;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);
    }

    public void move (){
        xpos = xpos + dx;
        ypos = ypos + dy;
    }








}
