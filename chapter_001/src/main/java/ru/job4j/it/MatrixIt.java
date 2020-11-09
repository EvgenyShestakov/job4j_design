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
        int sum = 0;
        for (int i = row;i < data.length;i++) {
        sum += data[i].length;
        }
        return row < data.length && sum != 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (data[row].length == 0) {
            row++;
        }
        int x = data[row][column++];
        if (column == data[row].length) {
            column = 0;
            row++;
        }
        return x;
    }
}
