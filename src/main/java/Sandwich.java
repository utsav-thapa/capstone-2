import Enums.*;

import java.util.HashSet;

public class Sandwich {

    private Size size;
    private Bread bread;
    private Meat meat;
    private boolean extraMeat;
    private Cheese cheese;
    private boolean extraCheese;
    private Sauce sauce;
    private boolean isToasted;

    private HashSet<Topping> toppings = new HashSet<>();
    private HashSet<Side> sides = new HashSet<>();

    public Sandwich(){
    }

    public void setMeat(Meat meat) {

        this.meat = meat;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public void setExtraMeat(boolean extraMeat) {

        this.extraMeat = extraMeat;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setSauce(Sauce sauce) {this.sauce = sauce;}

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }



    public double getPrice() {
        double price;
        switch (this.size) {
            case SMALL:
                price = 5.50;
                break;
            case MEDIUM:
                price = 7.00;
                break;
            case LARGE:
                price = 8.50;
                break;
            default:
                throw new RuntimeException("Illegal size");
        }

        if (!this.meat.equals(Meat.NO_MEAT)){
            switch(this.size) {
                case SMALL:
                    price += 1.00;
                    break;
                case MEDIUM:
                    price += 2.00;
                    break;
                case LARGE:
                    price += 3.00;
                    break;
                default:
                    throw new RuntimeException("You don't want any meat then?");
            }


            if(this.extraMeat) {
                switch (this.size) {
                    case SMALL:
                        price += .50;
                        break;
                    case MEDIUM:
                        price += 1.00;
                        break;
                    case LARGE:
                        price += 1.50;
                        break;
                    default:
                        throw new RuntimeException("Illegal size");
                }
            }
            if (!this.cheese.equals(Cheese.NO_CHEESE)){
                switch (this.size){
                    case SMALL:
                        price += .75;
                        break;
                    case MEDIUM:
                        price += 1.50;
                        break;
                    case LARGE:
                        price += 2.25;
                        break;
                    default:
                        throw new RuntimeException("Do you want cheese or not?");
                }
            }
            if (this.extraCheese){
                switch (this.size){
                    case SMALL:
                        price += .30;
                        break;
                    case MEDIUM:
                        price += .60;
                        break;
                    case LARGE:
                        price += .90;
                        break;
                    default:
                        throw new RuntimeException("So you don't want cheese eh?");
                }
            }
        }

        return price;
    }

    public void addTopping(Topping a) {
        toppings.add(a);
    }

    public Size getSize() {
        return size;
    }

    public Bread getBread() {
        return bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public HashSet<Topping> getToppings() {
        return toppings;
    }

    public void isToasted(boolean isToasted) {
        this.isToasted = isToasted;

    }

    public boolean getToasted() {
        return isToasted;
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public HashSet<Side> getSides(){ return sides;

    }
}
