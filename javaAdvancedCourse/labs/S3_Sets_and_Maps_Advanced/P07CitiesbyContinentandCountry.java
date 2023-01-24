package S3_Sets_and_Maps_Advanced;

import java.util.*;

public class P07CitiesbyContinentandCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> towns = new LinkedHashMap<>();

        for (int i = 0; i < cycles; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!towns.containsKey(continent)) {
                towns.put(continent, new LinkedHashMap<>() {{
                    put(country, new ArrayList<>() {{
                        add(city);
                    }});
                }});
            } else {
                if (!towns.get(continent).containsKey(country)) {
                    towns.get(continent).put(country, new ArrayList<>() {{
                        add(city);
                    }});
                } else {
                    towns.get(continent).get(country).add(city);
                }
            }

        }
        //най-неразбираемото нещо, което съм писал :)
        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> entry : towns.entrySet()) {
            System.out.println(entry.getKey() + ":");

            String currentLine = String.valueOf(entry.getValue()).replaceAll("[{}]", "");

            String[] currentArr = currentLine.split("],");
            for (int i = 0; i < currentArr.length; i++) {
                String[] line = currentArr[i].trim().replaceAll("]", "").split("=\\[");

                System.out.print(line[0] + " -> ");

                for (int j = 1; j < line.length; j++) {
                    System.out.println(line[j].trim());
                }
            }
        }
    }
}
