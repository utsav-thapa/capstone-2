import Enums.Topping;

import java.util.ArrayList;

public class Order{
    private ArrayList<Sandwich> sandwichs = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();
    private String orderName;
    private double price;
    private boolean checkOut;

    public Order(String orderName) {

        this.orderName = orderName;
    }

    public void addSandwich(Sandwich s1) {
        sandwichs.add(s1);
    }

    public void addChip(Chips c1){
        chips.add(c1);
    }

    public void addDrink(Drink d1){
        drinks.add(d1);
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwichs;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }

    public String getOrderName() {
        return orderName;
    }

    //processes the order and generates a formatted receipt string

    public String processOrder(Order order){
        double cost = 0;
        StringBuilder output = new StringBuilder();

        output.append("\n\t\tDELI-CIOUS RECEIPT\n");
        output.append("====================================\n");

        output.append("\tOrder for ").append(getOrderName()).append("\n");

        output.append("====================================\n");


        // if there are sandwiches in order, loops through the order
        if (!sandwichs.isEmpty()) {

            output.append("\n\t\tSANDWICHES\n");

            for (Sandwich a : getSandwiches()) {
                output.append("------------------------------------\n");

                // displays sandwich size
                output.append("Size: ");

                switch(a.getSize()){
                    case SMALL:
                        output.append("4\"\n");
                        break;
                    case MEDIUM:
                        output.append("8\"\n");
                        break;
                    case LARGE:
                        output.append("12\"\n");
                        break;
                    default:
                        throw new RuntimeException("Wrong size matey!");


                }
                // displays bread type
                output.append("Bread type: ").append(a.getBread()).append("\n");

                // displays meat and extra meat option
                output.append("Meat: ").append(a.getMeat());
                output.append(" | Extra Meat: ").append(a.isExtraMeat()).append("\n");

                // displays cheese and extra cheese option
                output.append("Cheese: ").append(a.getCheese());
                output.append(" | Extra Cheese: ").append(a.isExtraCheese()).append("\n");

                //displays toppings
                output.append("Toppings\n");
                for (Topping t: a.getToppings()){
                    output.append(t).append("\n");
                }

                // displays sauce
                output.append("Sauce: ").append(a.getSauce()).append("\n");
                output.append("Toasted: ").append(a.getToasted()).append("\n");
                cost += a.getPrice();
                output.append("------------------------------------\n");
                output.append("Sandwich Price: $").append(a.getPrice()).append("\n");

            }

        }
        // checks if chips are there and runs it if there are chips in order
        if (chips.size() > 0){
            output.append("Chips\n");
            output.append("------------------------------------\n");
            double chipsCost = 0;
            for (Chips c : getChips()){
                cost += c.getPrice();
                chipsCost += c.getPrice();
            }
            output.append("Chips Price: $").append(chipsCost).append("\n");

        }

        // runs if there are drinks in order
        if (drinks.size()>0){
            output.append("------------------------------------\n");
            output.append("\nDRINKS\n");
            double drinksCost = 0;
            for (Drink d :getDrinks()){
                output.append("Size: ").append(d.getSize()).append("\n");
                cost += d.getPrice();
                drinksCost += d.getPrice();
            }
            output.append("Drinks Price: $").append(drinksCost).append("\n");
        }

        // displays total cost
        output.append("\n====================================\n");
        output.append("TOTAL COST: $").append(cost).append("\n");
        output.append("\n====================================\n");

        // returns the formatted receipt string
        return output.toString();
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }
}
