package S4_Methods;

import java.util.Scanner;

public class P09GreaterofTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeData = scanner.nextLine();

        if (typeData.equals("int")){
            int firstNum = Integer.parseInt(scanner.nextLine());
            int seceondNum = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(firstNum,seceondNum));

        } else if (typeData.equals("char")) {
            char firstSymbol = scanner.nextLine().charAt(0);
            char secondSymbol = scanner.nextLine().charAt(0);
            System.out.println(getMax(firstSymbol,secondSymbol));

        } else if (typeData.equals("string")) {
            String firstString = scanner.nextLine();
            String secondString = scanner.nextLine();
            System.out.println(getMax(firstString,secondString));
        }


    }
    public static int getMax(int firstNum, int secondNum){
    if (firstNum>secondNum) {
        return firstNum;
    } else {
        return secondNum;
    }
    }
    public static char getMax(char firstSymbol, char secondSymbol){
        if (firstSymbol>secondSymbol) {
            return firstSymbol;
        } else {
            return secondSymbol;
        }
    }
    public static String getMax(String fistString, String secondString){
        if (fistString.compareTo(secondString) >= 0) {
            return fistString;
        } else {
            return secondString;
        }
        }
    }