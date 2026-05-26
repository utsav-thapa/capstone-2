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

        System.out.println("Order for " + getOrderName());

        if (sandwichs.size() > 0) {
            for (Sandwich a : getSandwichs()) {
                System.out.println("Sandwich");
                System.out.print("Sandwich Size: ");
                switch(a.getSize()){
                    case SMALL:
                        System.out.println("4\"");
                        break;
                    case MEDIUM:
                        System.out.println("8\"");
                        break;
                    case LARGE:
                        System.out.println("12\"");
                        break;
                    default:
                        throw new RuntimeException("The system has broken.");


                }
                System.out.print("Meat: " + a.getMeat());
                System.out.println(" | Extra Meat: " + a.isExtraMeat());
                System.out.print("Cheese: " + a.getCheese());
                System.out.println(" | Extra Cheese: " + a.isExtraCheese());
                System.out.println("Toppings");
                for (Topping t: a.getToppings()){
                    System.out.println(t);
                }
                System.out.println("Sauce: " + a.getSauce());
                cost += a.getPrice();
                System.out.println("Sandwich Price: $" + a.getPrice() );

            }

        }
        if (chips.size() > 0){
            System.out.println("Chips");
            double chipsCost = 0;
            for (Chip c : getChips()){
                cost += c.getPrice();
                chipsCost += c.getPrice();
            }
            System.out.println("Chips Price: $" + chipsCost);

        }

        if (drinks.size()>0){
            System.out.println("Drinks");
            double drinksCost = 0;
            for (Drink d :getDrinks()){
                System.out.println("Drink: " + d.getSize());
                cost += d.getPrice();
                drinksCost += d.getPrice();
            }
            System.out.println("Drinks Price: $" +drinksCost);
        }
        System.out.println("Total Cost: $" + cost);
    }
}
