package hexlet;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class JsonTest {

    @Test
    public void test1() throws Exception {

        var actual = Differ.generate("src/test/resources/file1.json", "/home/kirill/Projects/java-project-71/app/src/test/resources/file2.json");
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
