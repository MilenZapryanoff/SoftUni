package Exam_preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daturaBombsCount = 0;
        int cherryBombsCount = 0;
        int smokeDecoyBombsCount = 0;


        int[] bombEffectInput = Arrays.stream(scanner.nextLine().split(", ")).
                mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> bombEffect = new ArrayDeque<>();
        for (int element : bombEffectInput) {
            bombEffect.offer(element);
        }

        int[] bombCasingInput = Arrays.stream(scanner.nextLine().split(", ")).
                mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        for (int element : bombCasingInput) {
            bombCasing.push(element);
        }

        while ((bombEffect.size() > 0 && bombCasing.size() > 0) &&
                !(daturaBombsCount >= 3 && cherryBombsCount >= 3 && smokeDecoyBombsCount >= 3)) {

            int currentBombEffect = bombEffect.peek();
            int currentBombCasing = bombCasing.pop();

            if (currentBombEffect + currentBombCasing == 40) {
                daturaBombsCount++;
                bombEffect.poll();
            } else if (currentBombEffect + currentBombCasing == 60) {
                cherryBombsCount++;
                bombEffect.poll();
            } else if (currentBombEffect + currentBombCasing == 120) {
                smokeDecoyBombsCount++;
                bombEffect.poll();
            } else {
                bombCasing.push(currentBombCasing - 5);
            }

        }

        if (daturaBombsCount >= 3 && cherryBombsCount >= 3 && smokeDecoyBombsCount >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.print("Bomb Effects: ");
        printBombEffects(bombEffect);

        System.out.print("Bomb Casings: ");
        printBombCasing(bombCasing);

        System.out.printf("Cherry Bombs: %d%n", cherryBombsCount);
        System.out.printf("Datura Bombs: %d%n", daturaBombsCount);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeDecoyBombsCount);
    }

    private static void printBombCasing(ArrayDeque<Integer> bombCasing) {
        if (bombCasing.size() > 0) {
            int cycle = bombCasing.size();
            for (int i = 0; i < cycle; i++) {
                if (i == cycle - 1) {
                    System.out.println(bombCasing.poll());
                } else {
                    System.out.print(bombCasing.poll() + ", ");
                }
            }
        } else {
            System.out.println("empty");
        }
    }

    private static void printBombEffects(ArrayDeque<Integer> bombEffect) {
        if (bombEffect.size() > 0) {
            int cycle = bombEffect.size();
            for (int i = 0; i < cycle; i++) {
                if (i == cycle - 1) {
                    System.out.println(bombEffect.poll());
                } else {
                    System.out.print(bombEffect.poll() + ", ");
                }
            }
        } else {
            System.out.println("empty");
        }
    }
}