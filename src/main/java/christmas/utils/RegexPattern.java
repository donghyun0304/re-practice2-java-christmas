package christmas.utils;

import java.util.regex.Pattern;

public enum RegexPattern {

    ONLY_NUMBER(Pattern.compile("^[0-9]+$")),
    NOT_INCLUDE_COMMA(Pattern.compile("^[^,]*$"));


    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input){
        return pattern.matcher(input).matches();
    }

}
