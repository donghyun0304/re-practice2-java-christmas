package christmas.utils;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<String> parseToStringListByDelimiter(final String str, final String delimiter){
        return Arrays.stream(str.split(delimiter))
                .collect(Collectors.toList());
    }

    public static String formatNumberWithCommas(int number) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(number);
    }
}
