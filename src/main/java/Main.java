public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();


        Order order = new Order("Utsav");

        Sandwich s1 = new Sandwich();
        s1.setSize(Size.MEDIUM);
        s1.setMeat(Meat.CHICKEN);
        s1.setBread(Bread.WHEAT);
        s1.setCheese(Cheese.SWISS);
        s1.setExtraCheese(true);
        s1.setExtraMeat(true);

        // loop
        s1.addTopping(Topping.LETTUCE);
        s1.addTopping(Topping.PICKLES);
        s1.addTopping(Topping.PEPPERS);
        s1.addTopping(Topping.JALAPENOS);
        s1.addTopping(Topping.GUACAMOLE);
        s1.addTopping(Topping.MUSHROOMS);
        s1.addTopping(Topping.TOMATOES);
        s1.addTopping(Topping.CUCUMBERS);

        s1.setSauce(Sauce.MAYO);

        System.out.println("Sandwich price: $" + s1.getPrice());




        Drink d1 = new Drink(Size.LARGE);
        System.out.println("Drinks price: $" + d1.getPrice());

        Chip c1 = new Chip();
        System.out.println("Chips Price: $" + c1.getPrice());

        order.addSandwich(s1);
        order.addDrink(d1);
        order.addChip(c1);

        System.out.println("Total: $" + order.getValue());

        order.processOrder();



        // TODO: create the class and save it in file
//        String orderDetails = order.getOrderDetails();
//
//        ReceiptFileManager.saveReceipt(order);

    }
}
