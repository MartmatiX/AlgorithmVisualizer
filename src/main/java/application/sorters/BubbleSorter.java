package application.sorters;

import javax.swing.*;

public class BubbleSorter implements Sorter {

    @Override
    public void sort(int[] array, JPanel panel) {
        new Thread(() -> {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        int tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;

                        SwingUtilities.invokeLater(panel::repaint);

                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
