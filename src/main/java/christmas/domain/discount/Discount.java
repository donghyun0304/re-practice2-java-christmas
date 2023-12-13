package christmas.domain.discount;

public abstract class Discount {

    private final String title;
    private final int price;

    public Discount(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
