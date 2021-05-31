package sk.stuba.fei.uim.oop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@AllArgsConstructor
abstract public class Tvary {
    @Setter
    @Getter
    int x,y,y2,x2;
    @Getter
    @Setter
    Color color;
    abstract void paintObject(Graphics g);
    abstract boolean ClickOnObject(int x, int y);
}
