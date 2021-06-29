package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Ignore("Pseudo tests")
public class StringGeneratorTest {

    @Test
    public void produce() {
        StringGenerator generator = new StringGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> library = Map.of("name", "Evgeny Shestakov", "subject", "you");
        String string = generator.produce(template, library);
        assertThat(string, is("I am a Evgeny Shestakov, Who are you?"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThereAreNoKeysInTheMap() {
        StringGenerator generator = new StringGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> library = Map.of("subject", "you");
        generator.produce(template, library);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThereAreExtraKeysInTheMap() {
        StringGenerator generator = new StringGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> library = Map.of("name", "Evgeny", "subject", "you",
                "surname", "Shestakov");
        generator.produce(template, library);
    }
}
