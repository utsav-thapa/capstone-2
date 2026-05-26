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

    public ArrayList<Sandwich> getSandwichs() {
        return sandwichs;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public String getOrderName() {
        return orderName;
    }

    public double getPrice() {
        return price;
    }

    public void processOrder(){
        double cost = 0;

        System.out.println("Order for " + this.orderName);

        if (!getSandwichs().isEmpty()) {
            System.out.println("Sandwich");
            for (Sandwich a : getSandwichs()) {
                System.out.println("Sandwich Size: " + a.getSize());
                System.out.print("Meat: " + a.getMeat());
                System.out.println(" | Extra meat:" + a.isExtraMeat());
                System.out.print("Cheese: " + a.getCheese());
                System.out.println(" | Extra Cheese: " + a.isExtraCheese());
                System.out.println("Toppings");
                for (Topping t: a.getToppings()){
                    System.out.println(t);
                }
                System.out.println("Sauce: " + a.getSauce());
                cost += a.getPrice();
                System.out.println("Price: $" + a.getPrice() );

            }

        }
        if (!getChips().isEmpty()){
            System.out.println("Chips");
            for (Chip c : getChips()){
                cost += c.getPrice();
                System.out.println("Price: $" + c.getPrice());
            }
        }

        if (!getDrinks().isEmpty()){
            System.out.println("Drinks");
            for (Drink d :getDrinks()){
                System.out.println("Drink: " + d.getSize());
                cost += d.getPrice();
                System.out.println("Price: $" + d.getPrice());
            }
        }
        System.out.println("Total Cost: $" + cost);
    }
}
