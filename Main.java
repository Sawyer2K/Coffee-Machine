import java.util.Scanner;

class CoffeeMachine {
    private static int waterAvailable = 400;
    private static int milkAvailable = 540;
    private static int beansAvailable = 120;
    private static int disposableCups = 9;
    private static int moneyAmount = 550;

    private static void infoMsg() {
        System.out.println("The coffee machine has:\n" +
                waterAvailable + " of water\n" +
                milkAvailable + " of milk\n" +
                beansAvailable + " of coffee beans\n" +
                disposableCups + " of disposable cups\n" +
                moneyAmount + " of money");
    }

    private static void mainMenu() {
        Scanner scr = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            switch (scr.next()) {
                case "buy":
                    chooseSortOfCoffee();
                    break;
                case "fill":
                    fillResources();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    infoMsg();
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
            System.out.println();
        }
    }

    private static void chooseSortOfCoffee() {
        Scanner scr = new Scanner(System.in);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, break - to main menu: ");
        if (scr.hasNextInt()) {
            switch (scr.nextInt()) {
                case 1:
                    makeCoffee(250, 0, 16, 4);
                    break;
                case 2:
                    makeCoffee(350, 75, 20, 7);
                    break;
                case 3:
                    makeCoffee(200, 100, 12, 6);
                    break;
            }
        } else {
            switch (scr.next()) {
                case "break":
                    break;
            }
        }

        System.out.println();
    }

    private static boolean checkResources(int water, int milk, int beans) {
        if (waterAvailable >= water & milkAvailable >= milk & beansAvailable >= beans & disposableCups >= 1) {
            return true;
        } else {
            return false;
        }
    }

    private static void makeCoffee(int water, int milk, int beans, int cost) {
        if (checkResources(water, milk, beans)) {
            System.out.println("I have enough resources, making you a coffee!");
            waterAvailable -= water;
            milkAvailable -= milk;
            beansAvailable -= beans;
            disposableCups--;
            moneyAmount += cost;
        } else {
            System.out.println("Sorry, not enough water!");
        }
    }

    private static void fillResources() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water do you want to add:");
        waterAvailable += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkAvailable += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beansAvailable += scanner.nextInt();
        System.out.println("WWrite how many disposable cups of coffee do you want to add:");
        disposableCups += scanner.nextInt();
        System.out.println();
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + moneyAmount);
        moneyAmount = 0;
        System.out.println();
    }

    public static void main(String[] args) {
        mainMenu();
    }
}