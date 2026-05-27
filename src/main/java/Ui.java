import Enums.Bread;
import Enums.Meat;
import Enums.Size;

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
                    break;
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
        Bread breadType = switch (breadTypeInput) {
            case 1 -> Bread.WHITE;
            case 2 -> Bread.WHEAT;
            case 3 -> Bread.RYE;
            case 4 -> Bread.WRAP;
            default -> throw new IllegalArgumentException("Wrong Bread Type!");
        };

        String breadSizeMenu = """
                Select the bread size:
                1. 4"
                2. 8"
                3. 12"
                Enter: """;
        System.out.print(breadSizeMenu);

        int sizeInput = Integer.parseInt(scanner.nextLine());

        Size breadSize = switch (sizeInput) {
            case 1 -> Size.SMALL;
            case 2 -> Size.MEDIUM;
            case 3 -> Size.LARGE;
            default -> throw new IllegalArgumentException("Wrong Bread Size!");
        };

        Sandwich sandwich = new Sandwich(breadType, breadSize);

        String toppingsMenu = """
                Below is the toppings Menu:
                1. Meat
                2. Cheese
                3. Other toppings
                4. Sauces
                """;

        System.out.println(toppingsMenu);

        int toppingSelection = Integer.parseInt(scanner.nextLine());

        switch (toppingSelection) {
            case 1:
                addMeat(sandwich);
                break;
            case 2:
                addCheese(sandwich);
                break;
            case 3:
                addToppings(sandwich);
                break;
            case 4:
                addSauce(sandwich);
                break;
            default:
                throw new IllegalArgumentException("Wrong topping input!");
        }




    }

    private void addMeat(Sandwich sandwich) {
        String meatOptions = """
                Here are the meat options:
                1. Steak
                2. Ham
                3. Salami
                4. Roast Beef
                5. Chicken
                6. Bacon
                0. No Meat
                """;
        System.out.println(meatOptions);

        int meatInput = Integer.parseInt(scanner.nextLine());


        Meat meat = switch (meatInput) {
            case 1 -> Meat.STEAK;
            case 2 -> Meat.HAM;
            case 3 -> Meat.SALAMI;
            case 4 -> Meat.ROASTBEEF;
            case 5 -> Meat.CHICKEN;
            case 6 -> Meat.BACON;
            case 0 -> Meat.NO_MEAT;
            default -> throw new IllegalArgumentException("Wrong type of Meat!");
        };
        sandwich.setMeat(meat);

        if (!meat.equals(Meat.NO_MEAT)) {
            System.out.println("Would you like extra Meat? (Y/N)");

            String extraMeat = scanner.nextLine();
            if (extraMeat.equalsIgnoreCase("Y")){
                sandwich.setExtraMeat(true);
            }
        }
    }

    private void addCheese(Sandwich sandwich) {
        String cheeseOptions;

    }

    private void addToppings(Sandwich sandwich) {

    }

    private void addSauce(Sandwich sandwich) {

    }


    private void addDrink(Order order) {

    }

    private void addChips(Order order) {

    }

    private void checkout(Order order) {
    }




}

