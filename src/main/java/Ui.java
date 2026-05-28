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

            System.out.println(homeScreen + "Enter:");


            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    newOrder();
                    break;
                case "0":
                    System.out.println("Thank you for visiting deli-cious sandwich shop.");
                    running = false;
                    break;
                default:
                    System.err.println("Wrong input! Try again!");
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
                    5. Signature Sandwich (Bonus)
                    0. Exit
                    """;

            System.out.println(orderScreen + "Enter: ");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    addSandwich(order);
                    break;
                case "2":
                    addDrink(order);
                    break;
                case "3":
                    addChips(order);
                    break;
                case "4":
                    if (!(order.getDrinks().isEmpty()) || !(order.getSandwiches().isEmpty()) || !(order.getChips().isEmpty())) {
                        checkout(order);
                        if (order.isCheckOut()) {
                            running = false;
                        }
                    } else {
                        System.out.println("your order is empty.");
                    }
                    break;
                case "5":
                    addSignatureSandwich(order);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.err.println("Are you trying to break to system? Try again!");
            }
        } while (running);
    }

    private void addSignatureSandwich(Order order) {
        Sandwich sandwich = new Sandwich();
        String signatureMenu = """
                Below is a list of signature sandwiches we have.
                1. BLT
                2. Philly Cheese Steak
                3. Grilled Chicken
                4. Ham & Swiss
                5. Veggie
                """;
        boolean running = true;
        do {

            System.out.println(signatureMenu + "\nEnter: ");
            String signatureSandwichInput = scanner.nextLine();

            switch (signatureSandwichInput) {
                case "1":
                    blt(sandwich);
                    running = false;
                    break;
                case "2":
                    philly(sandwich);
                    running = false;
                    break;
                case "3":
                    grilledChicken(sandwich);
                    running = false;
                    break;
                case "4":
                    hamSwiss(sandwich);
                    running = false;
                    break;
                case "5":
                    veggie(sandwich);
                    running = false;
                    break;
                default:
                    System.err.println("We don't have that sandwich.");
            }
        } while (running);
        order.addSandwich(sandwich);
    }

    private void blt(Sandwich sandwich) {
        sandwich.setBread(Bread.WHITE);
        sandwich.setSize(Size.MEDIUM);
        sandwich.setMeat(Meat.BACON);
        sandwich.setCheese(Cheese.CHEDDAR);
        sandwich.addTopping(Topping.LETTUCE);
        sandwich.addTopping(Topping.TOMATOES);
        sandwich.isToasted(true);
    }

    private void philly(Sandwich sandwich) {
        sandwich.setBread(Bread.WHITE);
        sandwich.setSize(Size.MEDIUM);
        sandwich.setMeat(Meat.STEAK);
        sandwich.setCheese(Cheese.AMERICAN);
        sandwich.addTopping(Topping.PEPPERS);
        sandwich.setSauce(Sauce.MAYO);
        sandwich.isToasted(true);

    }

    private void grilledChicken(Sandwich sandwich) {
        sandwich.setBread(Bread.WHITE);
        sandwich.setSize(Size.MEDIUM);
        sandwich.setMeat(Meat.CHICKEN);
        sandwich.setCheese(Cheese.AMERICAN);
        sandwich.addTopping(Topping.LETTUCE);
        sandwich.addTopping(Topping.TOMATOES);
        sandwich.addTopping(Topping.ONIONS);
        sandwich.setSauce(Sauce.RANCH);
        sandwich.isToasted(true);
    }

    private void hamSwiss(Sandwich sandwich) {
        sandwich.setBread(Bread.WHITE);
        sandwich.setSize(Size.MEDIUM);
        sandwich.setMeat(Meat.HAM);
        sandwich.setCheese(Cheese.SWISS);
        sandwich.addTopping(Topping.LETTUCE);
        sandwich.addTopping(Topping.TOMATOES);
        sandwich.setSauce(Sauce.MAYO);
        sandwich.isToasted(true);
    }

    private void veggie(Sandwich sandwich) {
        sandwich.setBread(Bread.WHEAT);
        sandwich.setSize(Size.MEDIUM);
        sandwich.setMeat(Meat.NO_MEAT);
        sandwich.setCheese(Cheese.CHEDDAR);
        sandwich.addTopping(Topping.LETTUCE);
        sandwich.addTopping(Topping.MUSHROOMS);
        sandwich.addTopping(Topping.GUACAMOLE);
        sandwich.addTopping(Topping.CUCUMBERS);
        sandwich.addTopping(Topping.ONIONS);
        sandwich.isToasted(true);
    }


    private void addSandwich(Order order) {
        Sandwich sandwich = new Sandwich();
        breadTypeSelection(sandwich);

        breadSizeSelection(sandwich);

        boolean running = true;
        String toppingsMenu = """
                What would you like to add to your sandwich?
                
                1. Meat
                2. Cheese
                3. Other toppings
                4. Select Sauces
                5. Sides
                0. Exit
                """;
        do {

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
                case "5":
                    addSides(sandwich);
                    break;
                case "0":
                    toasted(sandwich);
                    running = false;
                    break;
                default:
                    System.err.println("Wrong input!");
            }
        } while (running);
        order.addSandwich(sandwich);
    }

    private void addSides(Sandwich sandwich) {
        String sidesMenu = """
                Below are the sides we have.
                1. Au Jus
                2. Sauce
                0. Exit""";

        boolean running = true;

        do {
            System.out.println(sidesMenu + "\nEnter: ");
            String sidesInput = scanner.nextLine();

            switch (sidesInput) {
                case "1":
                    addSide(sandwich, Side.AU_JUS);
                    break;
                case "2":
                    addSide(sandwich, Side.SAUCE);

                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("We don't have that side.");
            }

        } while (running);
    }

    private void addSide(Sandwich sandwich, Side side) {
        if (!sandwich.getSides().contains(side)) {
            sandwich.addSide(side);
            System.out.println(side.toString() + " added in sandwich.");
        } else {
            System.out.println("You already have " + side.toString() + " in your sandwich.");
        }
    }

    private static void toasted(Sandwich sandwich) {
        boolean running = true;

        do {

            if (sandwich != null) {
                System.out.println("Would you like your sandwich toasted? (Y/N)");
                String toastedOutput = scanner.nextLine();

                switch (toastedOutput) {
                    case "y", "Y":
                        sandwich.isToasted(true);
                        System.out.println("Sandwich will be toasted.");
                        running = false;
                        break;
                    case "n", "N":
                        sandwich.isToasted(false);
                        System.out.println("Sandwich will not be toasted.");
                        running = false;
                        break;
                    default:
                        System.err.println("Do you want it toasted or not?");
                }
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
            String breadTypeInput = scanner.nextLine();

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
        if (sandwich.getMeat() != null && !sandwich.getMeat().equals(Meat.NO_MEAT)) {
            System.err.println("You have already selected meat: " + sandwich.getMeat());
            return;
        }
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
            System.out.println(meatOptions + "Enter: ");

            String meatInput = scanner.nextLine();

            switch (meatInput) {
                case "1":
                    meat = Meat.STEAK;
                    running = false;
                    break;
                case "2":
                    meat = Meat.HAM;
                    running = false;
                    break;
                case "3":
                    meat = Meat.SALAMI;
                    running = false;
                    break;
                case "4":
                    meat = Meat.ROAST_BEEF;
                    running = false;
                    break;
                case "5":
                    meat = Meat.CHICKEN;
                    running = false;
                    break;
                case "6":
                    meat = Meat.BACON;
                    running = false;
                    break;
                case "0":
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
        if (sandwich.getCheese() != null && !sandwich.getCheese().equals(Cheese.NO_CHEESE)) {
            System.err.println("You have already selected cheese: " + sandwich.getCheese());
            return;
        }
        Cheese cheese = null;
        boolean running = true;
        String cheeseOptions = """
                Here are the cheese options.
                1. American
                2. Provolone
                3. Cheddar
                4. Swiss
                0. No Cheese
                """;
        do {
            System.out.print(cheeseOptions + "\nEnter: ");
            String cheeseInput = scanner.nextLine();

            switch (cheeseInput) {
                case "1":
                    cheese = Cheese.AMERICAN;
                    running = false;
                    break;
                case "2":
                    cheese = Cheese.PROVOLONE;
                    running = false;
                    break;
                case "3":
                    cheese = Cheese.CHEDDAR;
                    running = false;
                    break;
                case "4":
                    cheese = Cheese.SWISS;
                    running = false;
                    break;
                case "0":
                    cheese = Cheese.NO_CHEESE;
                    running = false;
                    break;
                default:
                    System.err.println("Wrong cheese type.");
            }
        } while (running);

        sandwich.setCheese(cheese);
        System.out.println(cheese.toString() + " Cheese selected.");

        if (!cheese.equals(Cheese.NO_CHEESE)) {
            System.out.println("Would you like extra cheese? (Y/N)");
            String extraCheese = scanner.nextLine();
            if (extraCheese.equalsIgnoreCase("Y")) {
                sandwich.setExtraCheese(true);
                System.out.println("Extra cheese added.");
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

            String toppingsInput = scanner.nextLine();

            switch (toppingsInput) {
                case "1":
                    addRegularTopping(sandwich, Topping.LETTUCE);
                    break;
                case "2":
                    addRegularTopping(sandwich, Topping.PEPPERS);
                    break;
                case "3":
                    addRegularTopping(sandwich, Topping.ONIONS);
                    break;
                case "4":
                    addRegularTopping(sandwich, Topping.TOMATOES);
                    break;
                case "5":
                    addRegularTopping(sandwich, Topping.JALAPENOS);
                    break;
                case "6":
                    addRegularTopping(sandwich, Topping.CUCUMBERS);
                    break;
                case "7":
                    addRegularTopping(sandwich, Topping.PICKLES);
                    break;
                case "8":
                    addRegularTopping(sandwich, Topping.GUACAMOLE);
                    break;
                case "9":
                    addRegularTopping(sandwich, Topping.MUSHROOMS);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.err.println("We don't have that topping type.");
            }
        } while (running);
    }

    private static void addRegularTopping(Sandwich sandwich, Topping topping) {
        if (!sandwich.getToppings().contains(topping)) {
            sandwich.addTopping(topping);
            System.out.println(topping.toString() + " added in sandwich.");
        } else {
            System.out.println("You already have " + topping.toString() + " in your sandwich.");
        }
    }

    private void addSauce(Sandwich sandwich) {
        String sauceMenu = """
                Here's the sauce menu.
                1. Mayo
                2. Mustard
                3. Ketchup
                4. Ranch
                5. Thousand Islands
                6. Vinaigrette
                """;
        boolean running = true;
        do {

            System.out.println(sauceMenu + "\nEnter: ");

            String sauceInput = scanner.nextLine();

            switch (sauceInput) {
                case "1":
                    sandwich.setSauce(Sauce.MAYO);
                    running = false;
                    break;
                case "2":
                    sandwich.setSauce(Sauce.MUSTARD);
                    running = false;
                    break;
                case "3":
                    sandwich.setSauce(Sauce.KETCHUP);
                    running = false;
                    break;
                case "4":
                    sandwich.setSauce(Sauce.RANCH);
                    running = false;
                    break;
                case "5":
                    sandwich.setSauce(Sauce.THOUSAND_ISLANDS);
                    running = false;
                    break;
                case "6":
                    sandwich.setSauce(Sauce.VINAIGRETTE);
                    running = false;
                    break;
                default:
                    System.err.println("That is not a sauce we have.");
            }
        } while (running);
    }


    private void addDrink(Order order) {



        String sizeMenu = """
                What size of drink would you like?
                1. Small
                2. Medium
                3. Large
                """;

        Size size = null;

        boolean running1 = true;

        do {
            System.out.println(sizeMenu + "\nEnter: ");

            String sizeInput = scanner.nextLine();


            switch (sizeInput) {
                case "1":
                    size = Size.SMALL;
                    running1 = false;
                    break;
                case "2":
                    size = Size.MEDIUM;
                    running1 = false;
                    break;
                case "3":
                    size = Size.LARGE;
                    running1 = false;
                    break;
                default:
                    System.err.println("That's not a size!");
            }
        } while (running1);

        Drink drink = new Drink(size);
        order.addDrink(drink);
        System.out.println(size.toString() + " drink added to order.");

    }

    private void addChips(Order order) {
        Chips chips = new Chips();
        order.addChip(chips);
        System.out.println("Chips added to order");
    }

    private void checkout(Order order) {
        System.out.println("Here's your receipt.");
        System.out.println(order.processOrder(order));
        String orderConfirmation = """
                Do you confirm your order?
                1. Confirm
                2. Go back
                """;
        boolean running = true;
        do {

            System.out.println(orderConfirmation + "\nEnter: ");
            String confirmationOutput = scanner.nextLine();

            switch (confirmationOutput) {
                case "1":
                    ReceiptsFileManager manager = new ReceiptsFileManager();
                    manager.saveReceipt(order);

                    System.out.println("Thank you for placing your order.");
                    order.setCheckOut(true);
                    running = false;
                    break;
                case "2":
                    order.setCheckOut(false);
                    running = false;
                    break;
                default:
                    System.err.println("We are the confirmation page. Don't play any games!");
            }
        }
        while (running);
    }
}

