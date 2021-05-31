package sk.stuba.fei.uim.oop;

import lombok.Setter;

import java.awt.*;
import java.awt.geom.*;

public class Kruh extends Tvary{
    @Setter
    int x,y,x2,y2;
    @Setter
    Color color;

    public Kruh(int x, int y, int x2, int y2, Color color) {
        super(x, y, y2, x2, color);
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void paintObject(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,x2,y2);
        g.setColor(Color.WHITE);
        g.fillOval(x+x2/3,y+y2/3,x2/3,y2/3);

    }

    @Override
    public boolean ClickOnObject(int x, int y) {
        Shape circle1 = new Ellipse2D.Double(this.x+x2/3,this.y+y2/3,x2/3,y2/3);
        if(circle1.contains(x,y)){
            return false;
        }
        Shape circle = new Ellipse2D.Double(this.x,this.y,x2,y2);
        if(circle.contains(x,y)){
            return true;
        }
        return false;
    }
}
