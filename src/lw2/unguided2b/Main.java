package lw2.unguided2b;
import java.util.*;

public class Main {


    public static void main(String[] args) {


        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foods = new LinkedList<>();
        LinkedList<String[]> drinks = new LinkedList<>();
        LinkedList<String[]> successful = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();


        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("orders.txt")
        );


        while (scanner.hasNext()) {


            String name = scanner.next();
            String food = scanner.next();
            String drink = scanner.next();
            String table = scanner.next();


            orders.add(new String[]{
                name, food, drink, table
            });
        }


        scanner.close();


        foods.add(new String[]{"Bakso", "2"});
        foods.add(new String[]{"Sate", "1"});
        foods.add(new String[]{"Soto", "2"});


        drinks.add(new String[]{"EsTeh", "4"});
        drinks.add(new String[]{"EsJeruk", "2"});


        Queue<String[]> queue = new LinkedList<>();
        queue.addAll(orders);


        while (!queue.isEmpty()) {


            String[] order = queue.poll();


            String food = order[1];
            String drink = order[2];


            String[] foodData = null;
            String[] drinkData = null;


            if (!food.equals("-")) {


                for (String[] item : foods) {


                    if (item[0].equals(food)) {
                        foodData = item;
                        break;
                    }
                }
            }


            if (!drink.equals("-")) {


                for (String[] item : drinks) {


                    if (item[0].equals(drink)) {
                        drinkData = item;
                        break;
                    }
                }
            }


            int foodStock = 1;
            int drinkStock = 1;


            if (!food.equals("-")) {
                foodStock =
                    Integer.parseInt(foodData[1]);
            }


            if (!drink.equals("-")) {
                drinkStock =
                    Integer.parseInt(drinkData[1]);
            }


            if (foodStock > 0 && drinkStock > 0) {


                if (!food.equals("-")) {
                    foodData[1] =
                        String.valueOf(foodStock - 1);
                }


                if (!drink.equals("-")) {
                    drinkData[1] =
                        String.valueOf(drinkStock - 1);
                }


                successful.add(order);


            } else {


                failed.push(order);
            }
        }


        System.out.println("=== Successfully Processed Orders  ===");


        for (String[] order : successful) {


            System.out.println(
                order[0] + " " +
                order[1] + " " +
                order[2] + " " +
                order[3]
            );
        }


        System.out.println("\n=== Remaining Food Stock  ===");


        for (String[] item : foods) {


            System.out.println(
                item[0] + " : " + item[1]
            );
        }


        System.out.println("\n=== Remaining Drink Stock  ===");


        for (String[] item : drinks) {


            System.out.println(
                item[0] + " : " + item[1]
            );
        }


        System.out.println("\n=== Failed Orders ===");


        while (!failed.isEmpty()) {


            String[] order = failed.pop();


            System.out.println(
                order[0] + " " +
                order[1] + " " +
                order[2] + " " +
                order[3]
            );
        }
    }
}



