package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class DrawUtils {
    public static void drawSun(Graphics2D g,int x, int y, int r, int l, int n, Color c){
        g.setColor(c);
        g.fillOval(x - r, y - r, r * 2, r * 2);

        double da = 2 * Math.PI / n;


        for (int i = 0; i < n; i++) {
            double a = i * da;
            double x1 = r * Math.cos(a) + x;
            double y1 = r * Math.sin(a) + y;
            double x2 = (r + l) * Math.cos(a) + x;
            double y2 = (r + l) * Math.sin(a) + y;

            g.drawLine((int) x1,(int) y1,(int) x2,(int) y2);
        }
    }
}
