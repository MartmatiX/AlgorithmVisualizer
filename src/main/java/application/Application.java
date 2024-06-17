package application;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
        System.out.println("""
                1 - Bubble sort
                2 - Selection sort
                3 - Insertion sort
                R - New data
                ESC - Exit
                """);
    }

}
