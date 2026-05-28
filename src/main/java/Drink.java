import Enums.Size;

public class Drink {
    Size size;
    Enums.Drink drink;

    public Drink(Size size, Enums.Drink drink) {

        this.size = size;
        this.drink = drink;
    }


    public double getPrice() {
        double price = 0;
        switch (this.size) {
            case SMALL:
                price = 2.00;
                break;
            case MEDIUM:
                price = 2.50;
                break;
            case LARGE:
                price = 3.00;
                break;
//            default:
//                throw new RuntimeException("Illegal size");
        }

        return price;
    }

    public Size getSize() {
        return size;
    }

    public Enums.Drink getDrink() {
        return drink;
    }
}


