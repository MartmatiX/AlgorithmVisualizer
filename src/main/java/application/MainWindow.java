package application;

import application.sorters.BubbleSorter;
import application.sorters.InsertionSorter;
import application.sorters.SelectionSorter;
import application.sorters.Sorter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class MainWindow {

    private int[] unsortedArray;

    private final JPanel mainPanel;

    private Sorter sorter;

    public MainWindow() {
        JFrame frame = new JFrame();
        frame.setTitle("Algorithm Visualizer");
        int WIDTH = 800;
        int HEIGHT = 600;
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        fillArray();

        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < unsortedArray.length; i++) {
                    g.drawRect(10 + i * 15, 10, 10, unsortedArray[i]);
                }
            }
        };

        mainPanel.setSize(WIDTH, HEIGHT);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_1 -> {
                        sorter = new BubbleSorter();
                        sorter.sort(unsortedArray, mainPanel);
                    }
                    case KeyEvent.VK_2 -> {
                        sorter = new SelectionSorter();
                        sorter.sort(unsortedArray, mainPanel);
                    }
                    case KeyEvent.VK_3 -> {
                        sorter = new InsertionSorter();
                        sorter.sort(unsortedArray, mainPanel);
                    }
                    case KeyEvent.VK_R -> {
                        fillArray();
                        mainPanel.repaint();
                    }
                    case KeyEvent.VK_ESCAPE -> System.exit(0);
                }

            }
        });

        frame.add(mainPanel);
    }

    private void fillArray() {
        int ARRAY_SIZE = 50;
        unsortedArray = new int[ARRAY_SIZE];
        Random random = new Random();
        int max = 400;

        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(max);
        }
    }
}
