package Exam_preparation.P03Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;
    private double heaviestPresent = Double.MIN_VALUE;


    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        Present currentPresent = null;
        for (int i = 0; i < data.size(); i++) {
            currentPresent = data.get(i);
            if (currentPresent.getName().equals(name)) {
                this.data.remove(currentPresent);
                return true;
            }
        }
        return false;
    }

    public Present getPresent(String name) {
        Present currentPresent = null;
        for (int i = 0; i < data.size(); i++) {
            currentPresent = data.get(i);
            if (currentPresent.getName().equals(name)) {
                break;
            }
        }
        return currentPresent;
    }

    public Present heaviestPresent() {
        Present heaviest = null;
        for (int i = 0; i < data.size(); i++) {
            Present currentPresent = data.get(i);
            if (currentPresent.getWeight() >= this.heaviestPresent) {
                heaviestPresent = currentPresent.getWeight();
                heaviest = currentPresent;
            }
        }
        return heaviest;
    }

    public StringBuilder report() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s bag contains:%n", this.color));
        for (int i = 0; i < data.size(); i++) {
            stringBuilder.append(String.format("%s%n", data.get(i)));
        }
        return stringBuilder;
    }
}
