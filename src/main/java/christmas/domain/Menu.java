package christmas.domain;

import java.util.List;
import java.util.stream.Collectors;

public enum Menu {

    APPETIZER(List.of(Food.MUSHROOM_SOUP, Food.TAPAS, Food.CAESAR_SALAD)),
    MAIN(List.of(Food.T_BONE_STEAK, Food.BBQ_RIBS, Food.SEAFOOD_PASTA, Food.CHRISTMAS_PASTA)),
    DESSERT(List.of(Food.CHOCOLATE_CAKE, Food.ICE_CREAM)),
    DRINK(List.of(Food.ZERO_COLA, Food.RED_WINE, Food.CHAMPAGNE));

    private List<Food> foods;

    Menu(List<Food> foods) {
        this.foods = foods;
    }

    public static boolean hasFoodInCategory(final Menu menu, final Food food){
        return menu.foods.contains(food);
    }

    public static boolean hasFoodInCategoryByName(final Menu menu, final String name){
        List<String> names = menu.foods.stream()
                .map(food -> food.getName())
                .collect(Collectors.toList());
        return names.stream()
                .anyMatch(n -> n.equals(name));
    }
}
