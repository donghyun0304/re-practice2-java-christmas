package christmas.domain;

public class Present {

    private final Food food;

    public Present() {
        this.food = Food.CHAMPAGNE;
    }

    public int getPrice(){
        return food.getPrice();
    }

    public String getName(){
        return food.getName();
    }
}
