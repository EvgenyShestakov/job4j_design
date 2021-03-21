package ru.job4j.io.exam;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShellTest {
    @Test
    public void whenCdBack() throws Exception {
        Shell shell = new Shell();
        shell.cd("/user/..");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdRoot() throws Exception {
        Shell shell = new Shell();
        shell.cd("/");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdUserLocal() throws Exception {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        assertThat(
                shell.pwd(), is("/user/local")
        );
    }

    @Test
    public void whenCdUserBack() throws Exception {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("..");
        assertThat(
                shell.pwd(), is("/")
        );
    }
}
