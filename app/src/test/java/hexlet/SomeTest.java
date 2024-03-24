package hexlet;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SomeTest {

    @Test
    public void testJSON() throws Exception {

        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json");
        var expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertEquals(actual, expected);
    }

    @Test
    public void testYAML() throws Exception {

        var actual = Differ.generate("src/test/resources/file1.yml", "src/test/resources/file2.yml");
        var expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertEquals(actual, expected);
    }
}
