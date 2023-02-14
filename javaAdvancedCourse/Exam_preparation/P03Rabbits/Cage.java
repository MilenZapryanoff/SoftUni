package Exam_preparation.P03Rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;
    private List<Rabbit> soldRabbit;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.capacity > this.data.size()) {
            this.data.add(rabbit);
        }
    }

    public void removeSpecies(String species) {
        Rabbit currentRabbit = null;
        for (int i = 0; i < data.size(); i++) {
            currentRabbit = data.get(i);
            if (currentRabbit.getSpecies().equals(species)) {
                this.data.remove(currentRabbit);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit currentRabbit = null;
        for (int i = 0; i < data.size(); i++) {
            currentRabbit = data.get(i);
            if (currentRabbit.getName().equals(name)) {
                currentRabbit.setAvailable(false);
                break;
            }
        }
        return currentRabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        soldRabbit = new ArrayList<>();
        Rabbit currentRabbit = null;
        for (int i = 0; i < data.size(); i++) {
            currentRabbit = data.get(i);
            if (currentRabbit.getSpecies().equals(species)) {
                currentRabbit.setAvailable(false);
                soldRabbit.add(currentRabbit);
            }
        }
        return soldRabbit;
    }


    public boolean removeRabbit(String name) {
        Rabbit currentRabbit = null;
        for (int i = 0; i < data.size(); i++) {
            currentRabbit = data.get(i);
            if (currentRabbit.getName().equals(name)) {
                this.data.remove(currentRabbit);
                return true;
            }
        }
        return false;
    }

    public int count() {
        return data.size();
    }

    public StringBuilder report() {
        Rabbit currentRabbit = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Rabbits available at %s:%n", this.name));
        for (int i = 0; i < data.size(); i++) {
            currentRabbit = data.get(i);
            if (currentRabbit.isAvailable()) {
                stringBuilder.append(String.format("%s%n", data.get(i)));
            }
        }
        return stringBuilder;
    }
}
