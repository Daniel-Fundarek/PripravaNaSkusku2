package sk.stuba.fei.uim.oop;

import lombok.Setter;

import java.awt.*;
import java.awt.geom.Line2D;


import static java.lang.Math.round;

public class Ciara extends Tvary{
    @Setter
    int x,y,x2,y2;
    @Setter
    Color color;

    public Ciara(int x, int y, int x2, int y2, Color color) {
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
        g.drawLine(x,y,x2,y2);
    }

    @Override
    public boolean ClickOnObject(int x, int y) {
        double dist = Line2D.ptLineDist(this.x,this.y,x2,y2,x,y);
        dist = round(dist);
        System.out.println(dist+" distance");
        if(dist<=1){
            return true;
        }
        return false;
    }

}
