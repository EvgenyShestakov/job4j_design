package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data[row].length == 0 && row <  data.length - 1) {
                row++;
        }
        return data[row].length != 0 && column != data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int x = data[row][column++];
        if (column == data[row].length && row < data.length - 1) {
            column = 0;
            row++;
        }
        return x;
    }
}
