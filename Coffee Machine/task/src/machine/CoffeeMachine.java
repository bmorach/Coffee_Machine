package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int water; int milk; int coffee; int disposableCups; int money; boolean mainMenu; Scanner userInput;

    public CoffeeMachine(int water, int milk, int coffee, int disposableCups, int money, Scanner userInput) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.disposableCups = disposableCups;
        this.money = money;
        this.userInput = userInput;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550, input);
        String[] actions = {"buy", "fill", "take", "remaining", "exit"};
        String actionSelected = "";
        while (!actionSelected.contains("exit".toLowerCase())) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            actionSelected = input.nextLine();
            if (actionSelected.equals(actions[0].toLowerCase())) {
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                actionSelected = input.nextLine();
                while (!actionSelected.equals("back".toLowerCase())) {
                    if (Integer.parseInt(actionSelected) == 1) {
                        if (machine.disposableCups > 1 && machine.water > 250 && machine.coffee > 16) {
                            machine.disposableCups -= 1;
                            machine.water -= 250;
                            machine.coffee -= 16;
                            machine.money += 4;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            if (machine.disposableCups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                            } else if (machine.water < 250) {
                                System.out.println("Sorry, not enough water!");
                            } else {
                                System.out.println("Sorry, not enough coffee");
                            }
                        }
                    }
                    if (Integer.parseInt(actionSelected) == 2) {
                        if (machine.disposableCups > 1 && machine.water > 350 && machine.milk > 75 && machine.coffee > 20) {
                            machine.disposableCups -= 1;
                            machine.water -= 350;
                            machine.milk -= 75;
                            machine.coffee -= 20;
                            machine.money += 7;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            if (machine.disposableCups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                            } else if (machine.water < 350) {
                                System.out.println("Sorry, not enough water!");
                            } else if (machine.milk < 75) {
                                System.out.println("Sorry, not enough milk!");
                            } else {
                                System.out.println("Sorry, not enough coffee!");
                            }
                        }
                    }
                    if (Integer.parseInt(actionSelected) == 3) {
                        if (machine.disposableCups > 1 && machine.water > 200 && machine.milk > 100 && machine.coffee > 12) {
                            machine.disposableCups -= 1;
                            machine.water -= 200;
                            machine.milk -= 100;
                            machine.coffee -= 12;
                            machine.money += 6;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            if (machine.disposableCups < 1) {
                                System.out.println("Sorry, not enough disposable cups!");
                            } else if (machine.water < 200) {
                                System.out.println("Sorry, not enough water!");
                            } else if (machine.milk < 100) {
                                System.out.println("Sorry, not enough milk!");
                            } else {
                                System.out.println("Sorry, not enough coffee!");
                            }
                        }
                    }
                    break;
                }
            }
            else if (actionSelected.equals(actions[1])) {
                machine.fill();
            }
            else if (actionSelected.equals(actions[2])) {
                machine.take();
            }
            else if (actionSelected.equals(actions[3])) {
                machine.remaining();
            }
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += Integer.parseInt(userInput.nextLine());
        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(userInput.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += Integer.parseInt(userInput.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCups += Integer.parseInt(userInput.nextLine());
    }

    public void take() {
        System.out.println("\nI gave you $" + money);
        money = 0;
    }

    public void remaining() {
        if (money <= 0 ) {
            System.out.println("\nThe coffee machine has:\n" +
                    water + " of water\n" +
                    milk + " of milk\n" +
                    coffee + " of coffee beans\n" +
                    disposableCups + " of disposable cups\n" +
                    money + " of money");
        } else {
            System.out.println("The coffee machine has:\n" +
                    water + " of water\n" +
                    milk + " of milk\n" +
                    coffee + " of coffee beans\n" +
                    disposableCups + " of disposable cups\n$" +
                    money + " of money");
        }
    }
}
