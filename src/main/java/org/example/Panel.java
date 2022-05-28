package org.example;

import java.awt.*;

public class Panel extends InterfaceObject {
    private Handler handler;
    private int x;
    private int y;
    private int width;
    private int height;
    private int gap;

    public Panel(int x, int y, ID id, Handler handler, int width, int height, int gap) {
        super(x, y, id, handler);
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gap = gap;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.lightGray);
        g.setStroke(new BasicStroke(5));
        g.drawRect(gap, gap, width - gap - 10, height - gap - 10);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
