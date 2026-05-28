import Enums.Size;

public class Drink {
    Size size;
    public Drink(Size size) {
        this.size = size;
    }

    // calculates drinks price based on the size
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
            default:
                throw new RuntimeException("Illegal size");
        }
        return price;
    }

    public Size getSize() {
        return size;
    }

}


