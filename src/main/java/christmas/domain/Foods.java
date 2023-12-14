package christmas.domain;

import java.util.EnumMap;
import java.util.Map;

public class Foods {

    private final Map<Food, Integer> foods;

    public Foods(Map<Food, Integer> foods) {
        this.foods = foods;
    }

    public int calcTotalPrice(){
        return foods.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
//    @Override
//    public String toString() {
//        return "Foods{" +
//                "foods=" + foods +
//                '}';
//    }
}
