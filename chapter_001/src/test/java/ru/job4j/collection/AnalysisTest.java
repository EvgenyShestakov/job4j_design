package ru.job4j.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import ru.job4j.collection.Analysis.User;
import ru.job4j.collection.Analysis.Info;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalysisTest {
    @Test
    public void whenTreeBinaryTrue() {
       Analysis analysis = new Analysis();
       List<User> previous = new ArrayList<>(Arrays.asList(new User(1, "Вася"),
               new User(2, "Женя"), new User(3, "Ваня"), new User(4, "Гена"),
               new User(5, "Света"), new User(10, "Наташа")));
       List<User> current = new ArrayList<>(Arrays.asList(new User(6, "Марина"),
                new User(2, "Женя"), new User(3, "Маша"), new User(4, "Слава"),
                new User(5, "Света")));
       Info result =  analysis.diff(previous, current);
       Info expected = new Info(1, 2, 2);
       assertThat(result, is(expected));
    }
}
