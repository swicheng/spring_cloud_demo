package cn.itcast.quartz.frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Windows {

    public static void main(String[] args) {

        Frame frame = new Frame();
        frame.setSize(500,400);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setTitle("windows");
    }

}
