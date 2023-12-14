package christmas.domain;

import java.util.List;

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

}
