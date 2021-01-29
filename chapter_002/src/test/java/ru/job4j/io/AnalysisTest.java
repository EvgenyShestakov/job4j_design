package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalysisTest {
    @Test
    public void whenTwoPeriods() {
        Analysis analysis = new Analysis();
        analysis.unavailable("C:/projects/job4j_design/chapter_002/src/"
                + "main/java/ru/job4j/io/resources/source.txt", "C:/projects/job4j_design/chapter_002/src/"
                + "main/java/ru/job4j/io/resources/target.txt");
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("C:/projects/job4j_design/chapter_002/src/"
                + "main/java/ru/job4j/io/resources/target.txt"))) {
            in.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(list.get(0), is("10:57:01;10:59:01;"));
        assertThat(list.get(1), is("11:01:02;11:02:02;"));
    }
}
