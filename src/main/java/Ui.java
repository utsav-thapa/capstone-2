import Enums.*;

import java.util.Scanner;

public class Ui {
    private static Scanner scanner = new Scanner(System.in);

    public void mainScreen() {
        boolean running = true;
        do {
            System.out.println("Welcome to Deli-cious Sandwich Shop");

            String homeScreen = """
                    1. New Order
                    0. Exit
                    """;

            System.out.println(homeScreen + "Enter:" );


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

            System.out.println(orderScreen + "Enter: ");
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
                    System.err.println("Are you trying to break to system? Try again!");
            }
        } while (running);
    }


    private void addSandwich(Order order) {
        Sandwich sandwich = new Sandwich();
        breadTypeSelection(sandwich);

        breadSizeSelection(sandwich);

        boolean running = true;
        do {
            String toppingsMenu = """
                    What would you like to add to your sandwich?
                    
                    1. Meat
                    2. Cheese
                    3. Other toppings
                    4. Select Sauces
                    0. Exit
                    """;

            System.out.println(toppingsMenu + "Enter: ");

            String toppingSelection = scanner.nextLine();

            switch (toppingSelection) {
                case "1":
                    addMeat(sandwich);
                    break;
                case "2":
                    addCheese(sandwich);
                    break;
                case "3":
                    addToppings(sandwich);
                    break;
                case "4":
                    addSauce(sandwich);
                    break;
                case "0":
                   running = false;
                default:
                    System.err.println("Wrong input!");
            }
        } while (running);
    }

    private void breadSizeSelection(Sandwich sandwich) {
        boolean running = true;
        do {
            String breadSizeMenu = """
                    Select the bread size:
                    1. 4"
                    2. 8"
                    3. 12"
                    """;

            System.out.print(breadSizeMenu + "Enter: ");

            String sizeInput = scanner.nextLine();

            switch (sizeInput) {
                case "1":
                    sandwich.setSize(Size.SMALL);
                    running = false;
                    break;
                case "2":
                    sandwich.setSize(Size.MEDIUM);
                    running = false;
                    break;
                case "3":
                    sandwich.setSize(Size.LARGE);
                    running = false;
                    break;
                default:
                    System.err.println("Wrong Bread Size! Try again.");
            }
        } while (running);
    }

    private void breadTypeSelection(Sandwich sandwich) {
        boolean running = true;
        do {

            String breadTypeMenu = """
                Select your bread:
                1. White
                2. Wheat
                3. Rye
                4. Wrap
                """;
            System.out.println(breadTypeMenu + "Enter:");
            String breadTypeInput =scanner.nextLine();

            switch (breadTypeInput) {
                case "1":
                    sandwich.setBread(Bread.WHITE);
                    running = false;
                    break;
                case "2":
                    sandwich.setBread(Bread.WHEAT);
                    running = false;
                    break;
                case "3":
                    sandwich.setBread(Bread.RYE);
                    running = false;
                    break;
                case "4":
                    sandwich.setBread(Bread.WRAP);
                    running = false;
                    break;
                default:
                    System.out.println("Wrong Bread Type!");
            }
        } while (running);
    }

    private void addMeat(Sandwich sandwich) {
        boolean running = true;
        Meat meat = null;
        do {
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
            System.out.println(meatOptions + "\nEnter: ");

            int meatInput = Integer.parseInt(scanner.nextLine());

            switch (meatInput) {
                case 1:
                    meat = Meat.STEAK;
                    running = false;
                    break;
                case 2:
                    meat = Meat.HAM;
                    running = false;
                    break;
                case 3:
                    meat = Meat.SALAMI;
                    running = false;
                    break;
                case 4:
                    meat = Meat.ROAST_BEEF;
                    running = false;
                    break;
                case 5:
                    meat = Meat.CHICKEN;
                    running = false;
                    break;
                case 6:
                    meat = Meat.BACON;
                    running = false;
                    break;
                case 0:
                    meat = Meat.NO_MEAT;
                    running = false;
                    break;
                default:
                    System.err.println("Wrong type of Meat!");
            }
        } while (running);

        sandwich.setMeat(meat);
        System.out.println("Sandwich meat: " + meat.toString() + " selected.");

        if (!meat.equals(Meat.NO_MEAT)) {
            System.out.println("Would you like extra Meat? (Y/N)" + "\nEnter: ");

            String extraMeat = scanner.nextLine();
            if (extraMeat.equalsIgnoreCase("Y")) {
                sandwich.setExtraMeat(true);
                System.out.println("Extra Meat added.");
            }
        }
    }

    private void addCheese(Sandwich sandwich) {
        Cheese cheese = null;
        boolean running = true;
        do {


            String cheeseOptions = """
                    Here are the cheese options.
                    1. American
                    2. Provolone
                    3. Cheddar
                    4. Swiss
                    0. No Cheese
                    """;
            System.out.print(cheeseOptions + "\nEnter: ");
            int cheeseInput = Integer.parseInt(scanner.nextLine());

            switch (cheeseInput) {
                case 1:
                    cheese = Cheese.AMERICAN;
                    running = false;
                    break;
                case 2:
                    cheese = Cheese.PROVOLONE;
                    running = false;
                    break;
                case 3:
                    cheese = Cheese.CHEDDAR;
                    running = false;
                    break;
                case 4:
                    cheese = Cheese.SWISS;
                    running = false;
                    break;
                case 0:
                    cheese = Cheese.NO_CHEESE;
                    running = false;
                    break;
                default:
                    System.err.println("Wrong cheese type.");
            }
        } while (running);

        sandwich.setCheese(cheese);

        if (!cheese.equals(Cheese.NO_CHEESE)) {
            System.out.println("Would you like extra cheese? (Y/N)");
            String extraCheese = scanner.nextLine();
            if (extraCheese.equalsIgnoreCase("Y")) {
                sandwich.setExtraCheese(true);
            }
        }
    }

    private void addToppings(Sandwich sandwich) {
        boolean running = true;
        do {
            String toppingsMenu = """
                    Here are the toppings available.
                    1. Lettuce
                    2. Peppers
                    3. Onions
                    4. Tomatoes
                    5. Jalapenos
                    6. Cucumbers
                    7. Pickles
                    8. Guacamole
                    9. Mushrooms
                    0. Exit""";
            System.out.println(toppingsMenu);

            int toppingsInput = Integer.parseInt(scanner.nextLine());

            switch (toppingsInput) {
                case 1:
                    addTopping(sandwich, Topping.LETTUCE);
                    break;
                case 2:
                    addTopping(sandwich, Topping.PEPPERS);
                    break;
                case 3:
                    addTopping(sandwich, Topping.ONIONS);
                    break;
                case 4:
                    addTopping(sandwich, Topping.TOMATOES);
                    break;
                case 5:
                    addTopping(sandwich, Topping.JALAPENOS);
                    break;
                case 6:
                    addTopping(sandwich, Topping.CUCUMBERS);
                    break;
                case 7:
                    addTopping(sandwich, Topping.PICKLES);
                    break;
                case 8:
                    addTopping(sandwich, Topping.GUACAMOLE);
                    break;
                case 9:
                    addTopping(sandwich, Topping.MUSHROOMS);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.err.println("We don't have that topping type.");
            }


        } while (running);
    }

    private static void addTopping(Sandwich sandwich, Topping topping) {
        if (!sandwich.getToppings().contains(topping)) {
            sandwich.addTopping(topping);
            System.out.println(topping.toString() + " added in sandwich.");
        } else {
            System.out.println("You already have " + topping.toString() +" in your sandwich.");
        }
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

