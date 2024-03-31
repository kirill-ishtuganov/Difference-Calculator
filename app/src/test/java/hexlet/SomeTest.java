package hexlet;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeTest {

    @Test
    public void testJSON() throws Exception {

        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "stylish");
        var expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertEquals(actual, expected);
    }

    @Test
    public void testYAML() throws Exception {

        var actual = Differ.generate("src/test/resources/file1.yml", "src/test/resources/file2.yml", "stylish");
        var expected = """
                {
                  - follow: false
                    host: hexlet.io
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [22, 33, 44, 55]
                  + numbers2: [2, 3, 4, 5]
                  - obj1: {nestedKey=value, isNested=true}
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertEquals(actual, expected);
    }
}
