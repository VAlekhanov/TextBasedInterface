package org.example;

import java.awt.*;

public class Label extends InterfaceObject {
    private Handler handler;
    private int x;
    private int y;
    private int width = 105;
    private int height = 32;
    private String text;
    private int stringLenght;

    public Label(int x, int y, ID id, Handler handler, String text) {
        super(x, y, id, handler);
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.text = text;
        stringLenght = countOfChars(text);
        width = stringLenght;
//        height = stringLenght;
    }

    private int countOfChars(String text) {
        int count = text.length();
        return count * 4 + 80;
    }

//    public void collusion() {
//        for (int i = 0; i < handler.objects.size(); i++) {
//            InterfaceObject object = handler.objects.get(i);
//            if (object.getId() == ID.Button) {
//                if()
//            }
//        }
//    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {
//        g.drawRect(x, y, width, height);
        g.setColor(Color.gray);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.drawString(text, x + width * 1 / 8, y + height * 5 / 8);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
