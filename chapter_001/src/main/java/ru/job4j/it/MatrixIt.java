package ru.job4j.it;

import org.w3c.dom.ls.LSOutput;

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
        System.out.println(row);
        return row < data.length && data[data.length - 1].length != 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column == data[row].length) {
            column = 0;
            row++;
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        /*int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        MatrixIt it = new MatrixIt(in);
        System.out.println(it.next());
        System.out.println(it.next());
        */int[][] in1 = {
                {7}, {}, {}, {}, {}
        };
        MatrixIt it1 = new MatrixIt(in1);
        System.out.println(it1.next());
        System.out.println(it1.hasNext());
    }

}
