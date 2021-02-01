package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalysisTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTwoPeriods() throws IOException {
        Analysis analysis = new Analysis();
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        analysis.write(source.getAbsolutePath());
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> list = analysis.download(target.getAbsolutePath());
        assertThat(list.get(0), is("10:57:01;10:59:01;"));
        assertThat(list.get(1), is("11:01:02;11:02:02;"));
    }
}
