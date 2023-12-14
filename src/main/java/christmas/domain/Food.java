package christmas.domain;

import christmas.utils.ErrorMessage;

import java.util.Arrays;

public enum Food {

    MUSHROOM_SOUP("양송이수프", 6_000), TAPAS("타파스", 5_500), CAESAR_SALAD("시저샐러드", 8_000),

    T_BONE_STEAK("티본스테이크", 55_000), BBQ_RIBS("바비큐립", 54_000), SEAFOOD_PASTA("해산물파스타", 35_000), CHRISTMAS_PASTA("크리스마스파스타", 25_000),

    CHOCOLATE_CAKE("초코케이크", 15_000), ICE_CREAM("아이스크림", 5_000),

    ZERO_COLA("제로콜라", 3_000), RED_WINE("레드와인", 60_000), CHAMPAGNE("샴페인", 25_000);

    private String name;
    private int price;

    Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static boolean hasFood(String name){
        return Arrays.stream(values())
                .anyMatch(food -> food.getName().equals(name));
    }

    public static Food find(String name){
        return Arrays.stream(values())
                .filter(food -> food.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND));
    }

//    @Override
//    public String toString() {
//        return "Food{" +
//                "name='" + name + '\'' +
//                ", price=" + price +
//                '}';
//    }
}
