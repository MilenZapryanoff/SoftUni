package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int softnessSum = 0;
        for (Toy toy : toys) {
            softnessSum += toy.getSoftness();
        }
        return softnessSum;
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity <= cats.size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        for (Cat currentCat : cats) {
            if (currentCat == cat) {
                cats.remove(cat);
            }
        }
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.stream().forEach(Cat::eating);
    }



    @Override
    public String getStatistics() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(":");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Cats: ");
        if (cats.isEmpty()) {
            stringBuilder.append("none");
        } else {
            for (Cat cat : cats) {
                stringBuilder.append(cat.getName()).append(" ");
            }
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Toys: ").append(toys.size()).append(" Softness: ").append(this.sumSoftness());
        stringBuilder.append(System.lineSeparator());
        return String.valueOf(stringBuilder);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
