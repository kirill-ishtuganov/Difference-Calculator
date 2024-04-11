package hexlet;

import hexlet.code.Differ;
import hexlet.code.utils.Utils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AppTest {

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public final void testDefaultFormat(String format) throws Exception {

        var actual = Differ.generate("src/test/resources/testedFiles/file1." + format,
                                     "src/test/resources/testedFiles/file2." + format);
        var expected = Utils.getUnparsedString("src/test/resources/rightAnswers/StylishAnswer");
        assertEquals(actual, expected);

        actual = Differ.generate("src/test/resources/testedFiles/file1." + format,
                                 "src/test/resources/testedFiles/file2." + format, "stylish");
        expected = Utils.getUnparsedString("src/test/resources/rightAnswers/StylishAnswer");
        assertEquals(actual, expected);

        actual = Differ.generate("src/test/resources/testedFiles/file1." + format,
                                 "src/test/resources/testedFiles/file2." + format, "plain");
        expected = Utils.getUnparsedString("src/test/resources/rightAnswers/PlainAnswer");
        assertEquals(actual, expected);

        actual = Differ.generate("src/test/resources/testedFiles/file1." + format,
                                 "src/test/resources/testedFiles/file2." + format, "json");
        expected = Utils.getUnparsedString("src/test/resources/rightAnswers/JsonAnswer");
        assertEquals(actual, expected);
    }
}
