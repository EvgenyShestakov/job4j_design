package ru.job4j.exam;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.*;

public class MailTest {
    @Test
    public void whenMailMerge() {
        List<Mail.User> list = new ArrayList<>();
        list.add(new Mail.User("User1", new HashSet<>(Arrays.
                asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"))));
        list.add(new Mail.User("User2", new HashSet<>(Arrays.
                asList("foo@gmail.com", "ups@pisem.net"))));
        list.add(new Mail.User("User3", new HashSet<>(Arrays.
                asList("xyz@pisem.net", "vasya@pupkin.com"))));
        list.add(new Mail.User("User4", new HashSet<>(Arrays.
                asList("ups@pisem.net", "aaa@bbb.ru"))));
        list.add(new Mail.User("User5", new HashSet<>(Arrays.
                asList("xyz@pisem.net"))));
        List<Mail.User> expected = new ArrayList<>();
        expected.add(new Mail.User("User3", new HashSet<>(Arrays.
                asList("vasya@pupkin.com", "xyz@pisem.net"))));
        expected.add(new Mail.User("User1", new HashSet<>(Arrays.
                asList("aaa@bbb.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "xxx@ya.ru"))));
        assertThat(new Mail().merge(list), is(expected));
    }
}
