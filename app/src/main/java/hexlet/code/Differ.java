package hexlet.code;

import java.util.Map;
import static hexlet.code.Parser.parse;
import static hexlet.code.utils.Utils.getFileFormat;
import static hexlet.code.utils.Utils.getUnparsedString;

public class Differ {

    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {


        Map<String, Object> file1 = parse(getUnparsedString(filepath1), getFileFormat(filepath1));
        Map<String, Object> file2 = parse(getUnparsedString(filepath2), getFileFormat(filepath2));
        return Formatter.formatting(Comparator.compare(file1, file2), formatName);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
