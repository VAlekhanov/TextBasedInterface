package org.example;

import java.awt.*;

public class Block extends InterfaceObject {
    private Handler handler;
    private int x;
    private int y;
    private int width = 105;
    private int height = 32;

    public Block(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
        this.x = x;
        this.y = y;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.darkGray);
        g.fillRect(x, y, width, height);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        return rectangle;
    }
}
