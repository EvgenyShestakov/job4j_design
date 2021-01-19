package ru.job4j.exam;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.*;

public class MailTest {
    @Test
    public void whenMailMerge() {
        Map<String, Set<String>> map = new HashMap<>();
        map.put("User1", new HashSet<>(Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        map.put("User2", new HashSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net")));
        map.put("User3", new HashSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")));
        map.put("User4", new HashSet<>(Arrays.asList("ups@pisem.net", "aaa@bbb.ru")));
        map.put("User5", new HashSet<>(Arrays.asList("xyz@pisem.net")));
        Map<String, Set<String>> expected = new HashMap<>();
        expected.put("User2", new HashSet<>(Arrays.
                asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru")));
        expected.put("User5", new HashSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")));
        assertThat(new Mail().merge(map), is(expected));
    }
}
