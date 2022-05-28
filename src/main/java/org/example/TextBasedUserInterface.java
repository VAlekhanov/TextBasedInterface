package org.example;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class TextBasedUserInterface extends Canvas implements Runnable {
    private boolean running = false;
    private String title = "Text Based User Interface";
    private int width = 640;
    private int height = width / 12 * 9;
    private int gap = width / 48;
    private Thread thread;
    private int countOfBuffers = 3;
    private long sleepTime = 15l;
    private Handler handler;

    public TextBasedUserInterface() throws IOException {
        new MainFrame(width, height, title, this);
        start();

        handler = new Handler();
        setComponents();

    }

    private void setComponents() {
        String text = "Hello World!";
        String textButton = "Кнопка";
        Label mainLabel = new Label(30, 0, ID.Label, handler, title);

        handler.addObject(new Panel(5, 5, ID.Panel, handler, width, height, gap));
        handler.addObject(mainLabel);
//        handler.addObject(new Block(50, 50, ID.Block, handler));
        handler.addObject(new Label(30, 50, ID.Label, handler, text));
//        handler.addObject(new Block(50, 100, ID.Block, handler));
        handler.addObject(new Label(30, 100, ID.Label, handler, "КУДА ПОШЕЛ"));
        handler.addObject(new Button(30, 150, ID.Button, handler, textButton));
    }

    private void tick() {
        for (int i = 0; i < handler.objects.size(); i++) {
//            if (handler.objects.get(i).getId() == ID.Player) {
//                camera.tick(handler.objects.get(i));
//            }
        }
        handler.tick();
    }

    private void render() throws InterruptedException {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(countOfBuffers);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.gray);
        g2.fillRect(0, 0, width, height);

//        g2.translate(width, height);

        handler.render(g2);

//        g2.translate(width, height);
        Thread.sleep(sleepTime);

        g2.dispose();
        bs.show();
    }


    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                try {
                    render();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
