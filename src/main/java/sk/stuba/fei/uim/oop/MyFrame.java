package sk.stuba.fei.uim.oop;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;

public class MyFrame extends JFrame implements ActionListener, ItemListener {


    MyCanvas canvas = new MyCanvas();
    JLabel label = new JLabel();
    public MyFrame() throws HeadlessException {
        this.setLayout(new BorderLayout());
        label.setForeground(Color.RED);
        label.setText("Jozo");
        JPanel topPanel = new JPanel();
        JPanel botPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,3));
        botPanel.setLayout(new GridLayout(1,2));

        JButton lineButton = new JButton("Line");
        JButton circleButton = new JButton("Circle");
        JButton colorButton = new JButton("Change Color");


        lineButton.addActionListener(this);
        circleButton.addActionListener(this);
        colorButton.addActionListener(this);

        Choice choice = new Choice();
        choice.addItemListener(this);

        choice.add("RED");
        choice.add("GREEN");
        choice.add("BLUE");


        topPanel.add(lineButton);
        topPanel.add(circleButton);
        topPanel.add(colorButton);

        botPanel.add(label);
        botPanel.add(choice);

        this.add(canvas,BorderLayout.CENTER);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(botPanel,BorderLayout.SOUTH);

        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.setObject(e.getActionCommand());
    }

    @SneakyThrows
    @Override
    public void itemStateChanged(ItemEvent e) {
        Field field = Class.forName("java.awt.Color").getField((String) e.getItem());
        Color color = (Color)field.get(null);
        canvas.setColor(color);
        label.setForeground(color);
        label.setText("JOzo");

    }
}
