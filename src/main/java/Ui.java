import Enums.Bread;

import java.util.Scanner;

public class Ui {

    private Scanner scanner = new Scanner(System.in);


    public void mainScreen() {
        boolean running = true;
        do {
            System.out.println("Welcome to Deli-cious Sandwich Shop");

            String homeScreen = """
                    1. New Order
                    0. Exit
                    """;

            System.out.println(homeScreen);


            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                case 1:
                    newOrder();
                    break;
                case 0:
                    System.out.println("Thank you for visiting deli-cious sandwich shop.");
                    running = false;
                    break;
                default:
                    System.err.println("Wrong input! Try again!");
                    break;
            }
        } while (running);
    }
    private void newOrder() {
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();

        Order order = new Order(userName);
        boolean running = true;

        do {

            String orderScreen = """
                    What would you like to order?
                    1. Sandwich
                    2. Drinks
                    3. Chips
                    4. Checkout
                    0. Exit
                    """;

            System.out.println(orderScreen);
            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                case 1:
                    addSandwich(order);
                    break;
                case 2:
                    addDrink(order);
                    break;
                case 3:
                    addChips(order);
                    break;
                case 4:
                    checkout(order);
                case 0:
                    running = false;
                    break;
                default:
                    throw new RuntimeException("Are you trying to break to system?");
            }
        } while (running);
    }


    private void addSandwich(Order order) {
        String breadTypeMenu = """
                Select your bread:
                1. White
                2. Wheat
                3. Rye
                4. Wrap 
                Enter: """;
        System.out.println(breadTypeMenu);
        int breadTypeInput = Integer.parseInt(scanner.nextLine());
        String breadType;

        switch (breadTypeInput){
            case 1:
                breadType = String.valueOf(Bread.WHITE);
                break;
            case 2:
                breadType = String.valueOf(Bread.WHEAT);
                break;
            case  3:
                breadType = String.valueOf(Bread.RYE);
                break;
            case 4:
                breadType = String.valueOf(Bread.WRAP);
                break;
            default:
                throw new RuntimeException("Wrong Bread Type!");

        }


        String breadSize = """
                    Select the bread size:
                    1. 4"
                    2. 8"
                    3. 12"
                    Enter: """;
        System.out.print(breadSize);
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
//                    Sandwich sandwich = new Sandwich();
        }




    }


    private void addDrink(Order order) {

    }

    private void addChips(Order order) {

    }

    private void checkout(Order order) {
    }




}

