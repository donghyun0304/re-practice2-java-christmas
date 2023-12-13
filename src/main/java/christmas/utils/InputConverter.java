package christmas.utils;

import christmas.domain.Food;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputConverter {
    public static Map<Food, Integer> parseFoods(List<String> input) {
        return input.stream()
                .map(foods -> foods.split(Delimiter.HYPHEN))
                .collect(Collectors.toMap(
                        splitArray -> Food.find(splitArray[0]),
                        splitArray -> Integer.parseInt(splitArray[1])
                ));
    }

}
