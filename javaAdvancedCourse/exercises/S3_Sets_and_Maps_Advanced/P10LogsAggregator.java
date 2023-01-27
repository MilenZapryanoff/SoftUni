package S3_Sets_and_Maps_Advanced;

import java.util.Scanner;
import java.util.TreeMap;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        TreeMap<String, Integer> userDurations = new TreeMap<>();
        TreeMap<String, TreeMap<String, Integer>> userIps = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            if (!userDurations.containsKey(user)) {
                userDurations.put(user, duration);
                userIps.put(user, new TreeMap<>());
                userIps.get(user).put(ip, 1);
            } else {
                userDurations.put(user, userDurations.get(user) + duration);
                if (!userIps.get(user).containsKey(ip)) {
                    userIps.get(user).put(ip, 1);
                } else {
                    userIps.get(user).put(ip, userIps.get(user).get(ip) + 1);
                }
            }
        }

        for (String user : userDurations.keySet()) {
            System.out.print(user + ": " + userDurations.get(user) + " ");
            System.out.print("[");
            int counter = 1;
            for (String ip : userIps.get(user).keySet()) {
                System.out.print(ip);
                if(counter<userIps.get(user).size()){
                    System.out.print(", ");
                }
                counter++;
            }
            System.out.print("]");
            System.out.println();
        }
    }
}