package S6_Defining_classes.P06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Pokemon>> pokemonsByTrainer = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] inputLine = input.split("\\s+");
            String trainerName = inputLine[0];
            String pokemonName = inputLine[1];
            String element = inputLine[2];
            int pokemonHealth = Integer.parseInt(inputLine[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, pokemonHealth);
            pokemonsByTrainer.putIfAbsent(trainerName, new ArrayList<>());
            pokemonsByTrainer.get(trainerName).add(pokemon);

            input = scanner.nextLine();
        }
        List<Trainer> trainerList = pokemonsByTrainer.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(command);
            }
            command = scanner.nextLine();
        }

        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }
}