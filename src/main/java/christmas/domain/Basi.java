package christmas.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public enum Basi {

    STAR(price -> isBetweenPrice(price, 5000, 10000)),
    TREE(price -> isBetweenPrice(price, 10000, 20000)),
    SANTA(price -> isMoreThanPrice(price, 20000));

    private Predicate<Integer> predicate;

    Basi(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    public static Optional<Basi> find(int price){
        return Arrays.stream(values())
                .filter(basi -> basi.predicate.test(price))
                .findAny();
    }

    private static boolean isBetweenPrice(int price, int startPrice, int endPrice){
        if(price >= startPrice && price < endPrice){
            return true;
        }
        return false;
    }

    private static boolean isMoreThanPrice(int price, int startPrice){
        if(price >= startPrice){
            return true;
        }
        return false;
    }
}
