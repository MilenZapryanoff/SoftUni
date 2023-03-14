package S4_Interfaces_and_Abstraction.P05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            String currentNumber = numbers.get(i);
            if (i == numbers.size() - 1) {
                if (!currentNumber.matches("\\d+")) {
                    stringBuilder.append("Invalid number!");
                    continue;
                }
                stringBuilder.append(String.format("Calling... %s", currentNumber));
            } else {
                if (!currentNumber.matches("\\d+")) {
                    stringBuilder.append(String.format("Invalid number!%n"));
                    continue;
                }
                stringBuilder.append(String.format("Calling... %s%n", currentNumber));

            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < urls.size(); i++) {
            String currentUrl = urls.get(i);

            if (i == numbers.size() - 1) {
                if (currentUrl.matches(".*\\d+.*")) {
                    stringBuilder.append("Invalid URL!");
                    continue;
                }
                stringBuilder.append(String.format("Browsing: %s!", currentUrl));

            } else {
                if (currentUrl.matches(".*\\d+.*")) {
                    stringBuilder.append(String.format("Invalid URL!%n"));
                    continue;
                }
                stringBuilder.append(String.format("Browsing: %s!%n", currentUrl));
            }
        }
        return stringBuilder.toString();
    }
}
