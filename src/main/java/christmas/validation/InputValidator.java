package christmas.validation;

import christmas.utils.ErrorMessage;

public class InputValidator {

    public static void validateNumeric(final String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC);
        }
    }

    public static void validateRangeNumber(int number){
        if(!(number >= 1 && number <= 31)){
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE);
        }
    }
}
