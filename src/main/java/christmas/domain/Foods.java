package christmas.domain;

import java.util.EnumMap;
import java.util.Map;

public class Foods {

    private final Map<Food, Integer> foods;

    public Foods(Map<Food, Integer> foods) {
        this.foods = foods;
    }

//    @Override
//    public String toString() {
//        return "Foods{" +
//                "foods=" + foods +
//                '}';
//    }
}
