package org.example;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<InterfaceObject> objects = new LinkedList<InterfaceObject>();

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            InterfaceObject tempObject = objects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < objects.size(); i++) {
            InterfaceObject tempObject = objects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(InterfaceObject tempObject) {
        objects.add(tempObject);
    }

    public void removeObject(InterfaceObject tempObject) {
        objects.remove(tempObject);
    }
}
