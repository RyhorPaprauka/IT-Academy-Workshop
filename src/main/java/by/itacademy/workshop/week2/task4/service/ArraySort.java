package by.itacademy.workshop.week2.task4.service;

import org.springframework.stereotype.Service;

@Service
public class ArraySort {

    public int[] modifiedBubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int j = 0;
            int k = 1;

            while (k <= n - i - 1) {
                if (isOdd(array[j])) {
                    if (isOdd(array[k])) {
                        if (array[j] > array[k]) {
                            swapDigits(array, j, k);
                        }
                        j++;
                        k++;
                    } else {
                        k++;
                    }
                } else {
                    j++;
                    k++;
                }
            }
        }
        return array;
    }

    private void swapDigits(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private boolean isOdd(int digit) {
        return digit % 2 != 0;
    }
}
