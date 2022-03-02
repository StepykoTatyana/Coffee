import java.util.Objects;
import java.util.Scanner;

public class Coffee {
    enum UserAction {
        buy, fill, take, remaining, exit
    }

    private static int water = 400;
    private static int milk = 540;
    private static int coffee = 120;
    private static int money = 550;
    private static int cups = 9;

    public static void main(String[] args) {
        action();
    }

    public static void printInfo() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", water, milk, coffee, cups, money);
        System.out.println();
    }

    public static void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.next();
        UserAction buy = UserAction.buy;
        UserAction fill = UserAction.fill;
        UserAction take = UserAction.take;
        UserAction remaining = UserAction.remaining;
        UserAction exit = UserAction.exit;
        while (!action.equals("exit")) {
            switch (action) {
                case "buy":
                    buy();
                    System.out.println();
                case "fill":
                    fill();
                    System.out.println();

                case "take":
                    take();
                    System.out.println();
                case "remaining":
                    System.out.println();
                    printInfo();
            }
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
        }

    }


    private static void take() {
        System.out.printf("I gave you $%d\n", money);
        money -= money;
    }

    private static void fill() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        double countOfWater = scanner.nextInt();
        water += countOfWater;
        System.out.println("Write how many ml of milk you want to add:");
        double countOfMilk = scanner.nextInt();
        milk += countOfMilk;
        System.out.println("Write how many grams of coffee beans you want to add:");
        double countOfCoffee = scanner.nextInt();
        coffee += countOfCoffee;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int countOfCups = scanner.nextInt();
        cups += countOfCups;
    }

    private static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.next();
        while (!coffeeType.equals("back")) {
            if (Objects.equals(coffeeType, "1")) {
                espresso();
                break;
            }
            if (Objects.equals(coffeeType, "2")) {
                latte();
                break;
            }
            if (Objects.equals(coffeeType, "3")) {
                cappuccino();
                break;
            }
        }
    }


    private static int checkLack(int waterForCoffee, int milkForCoffee, int coffeeForCoffee) {
        int lackWater = water - waterForCoffee;
        int lackMilk = milk - milkForCoffee;
        int lackCoffee = coffee - coffeeForCoffee;
        int lackCup = cups - 1;

        if (lackWater >= 0 && lackMilk >= 0 && lackCoffee >= 0 && lackCup >= 0) {
            return 1;
        } else {
            if (lackWater < 0) {
                System.out.println("Sorry, not enough water!");
            } else if (lackMilk < 0) {
                System.out.println("Sorry, not enough milk!");
            } else if (lackCoffee < 0) {
                System.out.println("Sorry, not enough coffee beans!");
            } else {
                System.out.println("Sorry, not enough cups!");
            }
            return -1;
        }
    }

    private static void cappuccino() {
        final int waterForCappuccino = 200;
        final int milkForCappuccino = 100;
        final int coffeeForCappuccino = 12;
        final int moneyForCappuccino = 6;
        final int cupForCappuccino = 1;
        int check = checkLack(waterForCappuccino, milkForCappuccino, coffeeForCappuccino);
        if (check == 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterForCappuccino;
            coffee -= coffeeForCappuccino;
            money += moneyForCappuccino;
            cups -= cupForCappuccino;
            milk -= milkForCappuccino;
        }
    }

    private static void latte() {
        final int waterForLatte = 350;
        final int milkForLatte = 75;
        final int coffeeForLatte = 20;
        final int moneyForLatte = 7;
        final int cupForLatte = 1;
        int check = checkLack(waterForLatte, milkForLatte, coffeeForLatte);
        if (check == 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterForLatte;
            coffee -= coffeeForLatte;
            money += moneyForLatte;
            cups -= cupForLatte;
            milk -= milkForLatte;
        }
    }

    private static void espresso() {
        final int waterForEspresso = 250;
        final int coffeeForEspresso = 16;
        final int moneyForEspresso = 4;
        final int cupForEspresso = 1;
        int check = checkLack(waterForEspresso, 0, coffeeForEspresso);
        if (check == 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterForEspresso;
            coffee -= coffeeForEspresso;
            money += moneyForEspresso;
            cups -= cupForEspresso;
        }
    }
}
