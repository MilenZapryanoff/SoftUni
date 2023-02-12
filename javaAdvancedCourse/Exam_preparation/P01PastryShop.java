package Exam_preparation;

import java.util.*;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitcount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int pieCount = 0;

        int[] liquidsInput = Arrays.stream(scanner.nextLine().split("\\s")).
                mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (int element : liquidsInput) {
            liquids.offer(element);
        }

        int[] ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s")).
                mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int element : ingredientsInput) {
            ingredients.push(element);
        }

        while (liquids.size() > 0 && ingredients.size() > 0) {

            int currentLiquid = liquids.peek();
            int currentIngredient = ingredients.peek();

            if (currentLiquid + currentIngredient == 25) {
                biscuitcount++;
                liquids.poll();
                ingredients.pop();

            } else if (currentLiquid + currentIngredient == 50) {
                cakeCount++;
                liquids.poll();
                ingredients.pop();

            } else if (currentLiquid + currentIngredient == 75) {
                pastryCount++;
                liquids.poll();
                ingredients.pop();

            } else if (currentLiquid + currentIngredient == 100) {
                pieCount++;
                liquids.poll();
                ingredients.pop();

            } else {
                int ingredientToAdd = ingredients.peek() + 3;
                liquids.poll();
                ingredients.pop();
                ingredients.push(ingredientToAdd);
            }
        }

        if (biscuitcount > 0 && cakeCount > 0 && pastryCount > 0 && pieCount > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.size() > 0) {
            System.out.print("Liquids left: ");
            int cycle = liquids.size();
            for (int i = 0; i < cycle; i++) {
                if (i == cycle - 1) {
                    System.out.println(liquids.poll());
                } else {
                    System.out.print(liquids.poll() + ", ");
                }
            }
        } else {
            System.out.println("Liquids left: none");
        }

        if (ingredients.size() > 0) {
            System.out.print("Ingredients left: ");
            int cycle = ingredients.size();
            for (int i = 0; i < cycle; i++) {
                if (i == cycle - 1) {
                    System.out.println(ingredients.pop());
                } else {
                    System.out.print(ingredients.pop() + ", ");
                }
            }
        } else {
            System.out.println("Ingredients left: none");
        }
        System.out.printf("Biscuit: %d%n", biscuitcount);
        System.out.printf("Cake: %d%n", cakeCount);
        System.out.printf("Pie: %d%n", pieCount);
        System.out.printf("Pastry: %d", pastryCount);
    }
}
