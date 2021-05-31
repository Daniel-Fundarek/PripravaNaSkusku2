package sk.stuba.fei.uim.oop;

import lombok.Setter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener {
    ArrayList<Tvary> objekty = new ArrayList<>();
    Tvary actual;
    @Setter
    private String object = "Line";
    @Setter
    Color color = Color.RED;
    int actx,acty;

    public MyCanvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Tvary obj: objekty){
            obj.paintObject(g);
        }
        if(actual!=null){
            actual.paintObject(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(object.equals("Change Color")){
            for (int i = objekty.size()-1; i>=0;i--){
                if(objekty.get(i).ClickOnObject(x,y)){
                    objekty.get(i).setColor(color);
                    break;
                }
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        actx = e.getX();
        acty = e.getY();
        if(object.equals("Line")){
          actual = new Ciara(actx,acty,actx,acty,color);
        }
        else if(object.equals("Circle")){
            actual = new Kruh(actx,acty,1,1,color);
        }
        else{

        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(actual!=null) {
            objekty.add(actual);
            actual = null;
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
       int x = e.getX();
       int y = e.getY();
        if(actual!= null){
            if(object.equals("Line")){
            actual.setX2(x);
            actual.setY2(y);
            }
            else if (object.equals("Circle")) {
                int size = ((abs(actx - x) > abs(acty - y)) ? abs(acty - y) : abs(actx - x));
                if (actx > x) {
                    actual.setX(actx - size);
                }
                if (acty > y){
                    actual.setY(acty - size);
                }
                actual.setX2(size);
                actual.setY2(size);
            }
            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
