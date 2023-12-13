package christmas.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<String> parseToStringListByDelimiter(final String str, final String delimiter){
        return Arrays.stream(str.split(delimiter))
                .collect(Collectors.toList());
    }
}
