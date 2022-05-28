package org.example;

import java.awt.*;

public class Button extends InterfaceObject {
    private Handler handler;
    private int x;
    private int y;
    private int width = 105;
    private int height = 32;
    private String text;

    public Button(int x, int y, ID id, Handler handler, String text) {
        super(x, y, id, handler);
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.text = text;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {
        g.drawRect(x, y, width, height);
        g.setColor(Color.darkGray);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.drawString(text, x + width * 1 / 8, y + height * 5 / 8);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
