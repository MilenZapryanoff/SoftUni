package S3_Sets_and_Maps_Advanced;

import java.util.*;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //създаване на основния мап
        TreeMap<String, LinkedHashMap<String, Integer>> logMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0].split("=")[1];
//          String message = input.split("\\s+")[1].split("=")[1];         съобщението не се използва в задачата
            String username = input.split("\\s+")[2].split("=")[1];

            if (!logMap.containsKey(username)) {
                logMap.put(username, new LinkedHashMap<>()); // като Value в основния мап добавяме нов MAP!
            }
            //работа с вътрешния мап
            Map<String, Integer> currentIps = logMap.get(username); // дефиниране на вътрешен МАП! и начина за работа с него

            if (!currentIps.containsKey(ip)) {
                currentIps.put(ip, 1);
            } else {
                int currentCount = currentIps.get(ip);
                currentIps.put(ip, currentCount + 1);
            }
            input = scanner.nextLine();
        }
        //печат на KEY от външния map
        for (String username : logMap.keySet()) {
            System.out.println(username + ": ");

            //вземат се данните от вътрешния map!
            Map<String, Integer> currentIps = logMap.get(username);
            int countIps = currentIps.size();

            //за да сложим точка, вместо запетая на последния запис от мапа, итерираме по мапа за да откроим последния
            //запис чрез изпозлване на .size на вътрешния архив
            for (String ip : currentIps.keySet()) {
                if (countIps == 1) {
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                } else {
                    //в случай, че не е последното IP
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                }
                //намаляме брояча с 1 за да разберем, когато стигнем до последния елемент == 1
                countIps--;
            }
        }
    }
}
