package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    public MainFrame(int width, int height, String title, TextBasedUserInterface tbui) {
        JFrame frame = new JFrame(title);
//        frame.setContentPane();
        frame.setPreferredSize(new Dimension(width + 15, height + 38));
        frame.setMinimumSize(new Dimension(width + 15, height + 38));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.add(tbui);
//        frame.add(MiniMap); todo Каким-то образом добавить мини-карту
        frame.setVisible(true);
        tbui.start();
    }


}
