public class Main {
    public static void main(String[] args) {
        Order order = new Order("Utsav");

        Sandwich s1 = new Sandwich();
        s1.setSize(Size.LARGE);
        s1.setMeat(Meat.CHICKEN);
        s1.setBread(Bread.WHITE);

        // loop
        s1.addTopping(Topping.LETTUCE);
        s1.addTopping(Topping.PICKLES);

        System.out.println(s1.getPrice());




        Drink d1 = new Drink(Size.MEDIUM);
        System.out.println(d1.getPrice());

        Chip c1 = new Chip();
        System.out.println(c1.getPrice());

        order.addSandwich(s1);
        order.addDrink(d1);
        order.addChip(c1);

        System.out.println(order.getValue());


        // TODO: create the class and save it in file
//        String orderDetails = order.getOrderDetails();
//
//        ReceiptFileManager.saveReceipt(order);

    }
}
