package ru.vsu.cs.galimov.tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final Color SKY_COLOR = new Color(100,100,250);
    private static final Color GROUND_COLOR = new Color(100,200,100);
    private static final Random rnd = new Random();
    private static Timer timer;
    private Sun s;

    // ctrl + o


    public DrawPanel() {
        s = new Sun(90 + rnd.nextInt(100), 60, 30, 25, 20, Color.YELLOW);
        timer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setX(s.getX() + 1);
                repaint();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (timer.isRunning()){
                    timer.stop();
                }
                else{
                    timer.start();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        /*g2d.drawLine(0,0,100,50);
        g2d.draw3DRect(100,100,300,300,false);
        g2d.setFont(new Font("consolas",Font.PLAIN, 20));
        g2d.setColor(Color.red);
        g2d.drawString("ewjfef",400,400);
        g2d.setStroke(new BasicStroke(30));// ширина пера
        g2d.setPaint(new GradientPaint());
        g2d.transform();*/

        /*g2d.setColor(Color.YELLOW);
        g2d.drawOval(400,200,50,50);
        g2d.fillOval(400,200,50,50);*/

        g2d.setColor(SKY_COLOR);
        g2d.fillRect(0,0, getWidth(), getHeight() / 2);

        g2d.setColor(GROUND_COLOR);
        g2d.fillRect(0,getHeight() / 2, getWidth(), getHeight());
        g2d.setStroke(new BasicStroke(3));


        s.draw(g2d);
    }

}
