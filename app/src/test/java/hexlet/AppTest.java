package hexlet;

import hexlet.code.Differ;
import hexlet.code.utils.Utils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AppTest {

    @Test
    public void testDefaultFormat() throws Exception {

        var actual = Differ.generate("src/test/resources/testedFiles/file1.json",
                                     "src/test/resources/testedFiles/file2.json");
        var expected = Utils.getUnparsedString("src/test/resources/rightAnswers/JsonStylishAnswer");
        assertEquals(actual, expected);

        actual = Differ.generate("src/test/resources/testedFiles/file1.yml",
                                 "src/test/resources/testedFiles/file2.yml");
        expected = Utils.getUnparsedString("src/test/resources/rightAnswers/YamlStylishAnswer");
        assertEquals(actual, expected);
    }

    @Test
    public void testStylishFormat() throws Exception {

        var actual = Differ.generate("src/test/resources/testedFiles/file1.json",
                                     "src/test/resources/testedFiles/file2.json", "stylish");
        var expected = Utils.getUnparsedString("src/test/resources/rightAnswers/JsonStylishAnswer");
        assertEquals(actual, expected);

        actual = Differ.generate("src/test/resources/testedFiles/file1.yml",
                                 "src/test/resources/testedFiles/file2.yml", "stylish");
        expected = Utils.getUnparsedString("src/test/resources/rightAnswers/YamlStylishAnswer");
        assertEquals(actual, expected);
    }

    @Test
    public void testPlainFormat() throws Exception {
        var actual = Differ.generate("src/test/resources/testedFiles/file1.json",
                                     "src/test/resources/testedFiles/file2.json", "plain");
        var expected = Utils.getUnparsedString("src/test/resources/rightAnswers/JsonPlainAnswer");
        assertEquals(actual, expected);

        actual = Differ.generate("src/test/resources/testedFiles/file1.yml",
                "src/test/resources/testedFiles/file2.yml", "plain");
        expected = Utils.getUnparsedString("src/test/resources/rightAnswers/YamlPlainAnswer");
        assertEquals(actual, expected);
    }
    @Test
    public void testJsonFormat() throws Exception {
        var actual = Differ.generate("src/test/resources/testedFiles/file1.json",
                "src/test/resources/testedFiles/file2.json", "json");
        var expected = Utils.getUnparsedString("src/test/resources/rightAnswers/JsonJsonAnswer");
        assertEquals(actual, expected);

        actual = Differ.generate("src/test/resources/testedFiles/file1.yml",
                "src/test/resources/testedFiles/file2.yml", "json");
        expected = Utils.getUnparsedString("src/test/resources/rightAnswers/YamlJsonAnswer");
        assertEquals(actual, expected);
    }
}
