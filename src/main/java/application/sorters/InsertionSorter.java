package application.sorters;

import javax.swing.*;

public class InsertionSorter implements Sorter {

    @Override
    public void sort(int[] array, JPanel panel) {
        new Thread(() -> {
            for (int i = 0; i < array.length - 1; i++) {
                int j = i + 1;
                int tmp = array[j];
                while (j > 0 && tmp > array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = tmp;

                SwingUtilities.invokeLater(panel::repaint);

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
