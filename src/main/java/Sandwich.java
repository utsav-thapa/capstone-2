import java.util.ArrayList;

public class Sandwich {

        private Size size;
        private Bread bread;
        private Meat meat;
        private boolean extraMeat;
        private double price;

        private ArrayList<Topping> toppings;

    public Sandwich() {
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

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }


    public double getPrice() {
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
//            default:
//                throw new RuntimeException("Illegal size");
        }
        //...

        if(this.extraMeat) {
            switch(this.size){
                case SMALL:
                    price += .50;
                    break;
                case MEDIUM:
                    price += 1.00;
                    break;
                case LARGE:
                    price += 1.50;
                    break;
//                default:
//                    throw new RuntimeException("Illegal size");
            }
           //todo: size dependant
        }
        return price;

    }

    public void addTopping(Topping topping) {
        toppings.add(topping);

    }
}
