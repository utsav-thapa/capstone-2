import java.util.Scanner;

public class Ui {

    private boolean running = true;

    public void mainScreen(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Deli-cious Sandwich Shop");

        String homeScreen = """
                1. New Order
                0. Exit
                """;



        String orderScreen = """
                What would you like to order?
                1. Sandwich
                2. Drinks
                3. Chips
                4. Checkout
                0. Exit
                """;
        Order order = new Order("userName");

        System.out.println(homeScreen);

        int userInput = Integer.parseInt(scanner.nextLine());
        switch (userInput){
            case 1:
                addSandwich();
                break;
            case 2:
                addDrink();
                break;
            case 3:
                addChips();
                break;
            case 4:
                running = false;
                break;
            default:
                throw new RuntimeException("Are you trying to break to system?");
        }
    }

    private void addSandwich() {

    }

    private void addDrink() {

    }

    private void addChips() {

    }


}

