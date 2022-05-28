package org.example;

import java.awt.*;

public class Cursor extends InterfaceObject {
    Handler handler;
    private int xBound = 23;
    private int yBound = 23;

    public Cursor(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
