package christmas.validation;

import christmas.domain.Food;
import christmas.utils.Delimiter;
import christmas.utils.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    //해산물파스타-2
    //해산물파스타-2,레드와인-1
    // 위와 같은 형식 정규식
    private static Pattern inputFoodPattern = Pattern.compile("([가-힣]+-\\d+)(,[가-힣]+-\\d+)*");

    public static void validateNumeric(final String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC);
        }
    }

    public static void validateRangeNumber(final int number){
        if(!(number >= 1 && number <= 31)){
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE);
        }
    }

    public static void validateInputMenuFormat(final String input){
        if(!inputFoodPattern.matcher(input).matches()){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_FORMAT);
        }
    }

    public static void validateValidFood(final List<String> foods){
        for (String food : foods) {
            String foodName = food.substring(0, food.indexOf(Delimiter.HYPHEN));
            if(!Food.hasFood(foodName)){
                throw new IllegalArgumentException(ErrorMessage.NOT_FOUND);
            }
        }
    }

    public static void validateValidOrderedNumber(final List<String> foods){
        for (String food : foods) {
            String orderedAmount= food.substring(food.indexOf(Delimiter.HYPHEN)+1);
            if(Integer.parseInt(orderedAmount) < 1){
                throw new IllegalArgumentException(ErrorMessage.NOT_OVER_ZERO);
            }
        }
    }

    public static void validateDuplicateNames(final List<String> orders) {
        List<String> names = orders.stream()
                .map(order -> order.substring(0, order.indexOf(Delimiter.HYPHEN)))
                .collect(Collectors.toList());
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATE);
        }
    }

    public static void validateFoodSize(final List<String> orders){
        int sum = orders.stream()
                .map(order -> order.substring(order.indexOf(Delimiter.HYPHEN) + 1))
                .mapToInt(amount -> Integer.parseInt(amount))
                .sum();
        if(sum > 20) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_CONDITION);
        }
    }
}
