package application.sorters;

import javax.swing.*;

public class SelectionSorter implements Sorter {

    @Override
    public void sort(int[] array, JPanel panel) {
        new Thread(() -> {
            for (int i = 0; i < array.length - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] > array[maxIndex]) {
                        maxIndex = j;
                    }
                }
                int tmp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = tmp;

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
