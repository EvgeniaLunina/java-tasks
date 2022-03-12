package ru.mail.polis.homework.objects;

import java.util.Arrays;
import java.util.Collections;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если массив null или его длина меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * НЕЛЬЗЯ СОРТИРОВАТЬ массив array и его копии
     */
    public static int[] getMaxArray(int[] array, int count) {
        if (array == null) {
            return (null);
        }
        int length = array.length;
        if (length < count) {
            return (null);
        }
        int[] array1 = new int[length];
        if ((length != 0) & (count != 0)) {

            array1[0] = array[0];
            for (int i = 1; i < length; i++) {
                array1[i] = array[i];
                int m = i;
                while (array1[m] > array1[m - 1]) {
                    array1[m] = array1[m - 1] + array1[m];
                    array1[m - 1] = array1[m] - array1[m - 1];
                    array1[m] = array1[m] - array1[m - 1];
                    m = m - 1;
                    if (m == 0) {
                        break;
                    }

                }
            }

        }
        int[] arraynew = new int[count];
        arraynew = Arrays.copyOfRange(array1, 0, count);
        return (arraynew);

    }

}