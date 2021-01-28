package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        Config config = new Config("app.properties");
        config.load();
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
    }
}
