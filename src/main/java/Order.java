import Enums.Topping;

import java.util.ArrayList;
import java.util.HashSet;

public class Order{
    private ArrayList<Sandwich> sandwichs = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private HashSet<Chip> chips = new HashSet<>();
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

    public ArrayList<Sandwich> getSandwiches() {
        return sandwichs;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public HashSet<Chip> getChips() {
        return chips;
    }

    public String getOrderName() {
        return orderName;
    }

    public double getPrice() {
        return price;
    }

//    public void processOrder(){
//        double cost = 0;
//        String output;
//
//        System.out.println("Order for " + getOrderName());
//
//        if (sandwichs.size() > 0) {
//            for (Sandwich a : getSandwichs()) {
//                System.out.println("Sandwich");
//                System.out.print("Sandwich Enums.Size: ");
//                switch(a.getSize()){
//                    case SMALL:
//                        System.out.println("4\"");
//                        break;
//                    case MEDIUM:
//                        System.out.println("8\"");
//                        break;
//                    case LARGE:
//                        System.out.println("12\"");
//                        break;
//                    default:
//                        throw new RuntimeException("The system has broken.");
//
//
//                }
//                System.out.print("Enums.Meat: " + a.getMeat());
//                System.out.println(" | Extra Enums.Meat: " + a.isExtraMeat());
//                System.out.print("Enums.Cheese: " + a.getCheese());
//                System.out.println(" | Extra Enums.Cheese: " + a.isExtraCheese());
//                System.out.println("Toppings");
//                for (Topping t: a.getToppings()){
//                    System.out.println(t);
//                }
//                System.out.println("Enums.Sauce: " + a.getSauce());
//                cost += a.getPrice();
//                System.out.println("Sandwich Price: $" + a.getPrice() );
//
//            }
//
//        }
//        if (chips.size() > 0){
//            System.out.println("Chips");
//            double chipsCost = 0;
//            for (Chip c : getChips()){
//                cost += c.getPrice();
//                chipsCost += c.getPrice();
//            }
//            System.out.println("Chips Price: $" + chipsCost);
//
//        }
//
//        if (drinks.size()>0){
//            System.out.println("Drinks");
//            double drinksCost = 0;
//            for (Drink d :getDrinks()){
//                System.out.println("Drink: " + d.getSize());
//                cost += d.getPrice();
//                drinksCost += d.getPrice();
//            }
//            System.out.println("Drinks Price: $" +drinksCost);
//        }
//        System.out.println("Total Cost: $" + cost);
//    }

    public String processOrder(Order order){
        double cost = 0;
        StringBuilder output = new StringBuilder();

        output.append("Order for ").append(getOrderName()).append("\n");

        if (sandwichs.size() > 0) {
            for (Sandwich a : getSandwiches()) {
                output.append("Sandwich\n");
                output.append("Sandwich Size: ");
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
                output.append("Bread type: ").append(a.getBread()).append("\n");
                output.append("Meat: ").append(a.getMeat());
                output.append(" | Extra Meat: ").append(a.isExtraMeat()).append("\n");
                output.append("Cheese: ").append(a.getCheese());
                output.append(" | Extra Cheese: ").append(a.isExtraCheese()).append("\n");
                output.append("Toppings\n");
                for (Topping t: a.getToppings()){
                    output.append(t).append("\n");
                }
                output.append("Sauce: ").append(a.getSauce()).append("\n");
                cost += a.getPrice();
                output.append("Sandwich Price: $").append(a.getPrice()).append("\n");

            }

        }
        if (chips.size() > 0){
            output.append("Chips\n");
            double chipsCost = 0;
            for (Chip c : getChips()){
                cost += c.getPrice();
                chipsCost += c.getPrice();
            }
            output.append("Chips Price: $").append(chipsCost).append("\n");

        }

        if (drinks.size()>0){
            output.append("Drinks\n");
            double drinksCost = 0;
            for (Drink d :getDrinks()){
                output.append("Drink: ").append(d.getSize()).append("\n");
                cost += d.getPrice();
                drinksCost += d.getPrice();
            }
            output.append("Drinks Price: $").append(drinksCost).append("\n");
        }
        output.append("Total Cost: $").append(cost).append("\n");
        return output.toString();
    }
}
