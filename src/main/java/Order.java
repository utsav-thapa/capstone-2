import java.util.ArrayList;

public class Order{
    private ArrayList<Sandwich> sandwichs = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chip> chips = new ArrayList<>();
    private String orderName;
    private double price;




    public Order(String orderName) {
        this.orderName = orderName;
    }

    public double getValue() {

        for (Sandwich a: sandwichs){
            price += a.getPrice();
        }
        for (Drink d : drinks) {
            price += d.getPrice();
        }
        for (Chip c : chips) {
            price += c.getPrice();
        }

        return price;
    }

    public void addSandwich(Sandwich s1) {
        sandwichs.add(s1);
    }

    public void addChip(Chip c1){
        chips.add(c1);
    }

    public void addDrink(Drink d1){
        drinks.add(d1);
    }
}
