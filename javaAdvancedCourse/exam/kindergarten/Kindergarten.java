package Exam.kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> data;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.capacity > this.data.size()) {
            this.data.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        Child currentChild = null;
        for (int i = 0; i < data.size(); i++) {
            currentChild = data.get(i);
            if (currentChild.getFirstName().equals(firstName)) {
                this.data.remove(currentChild);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount() {
        return this.data.size();
    }

    public Child getChild(String firstName) {
        Child currentChild = null;
        for (int i = 0; i < data.size(); i++) {
            currentChild = data.get(i);
            if (currentChild.getFirstName().equals(firstName)) {
                return currentChild;
            }
        }
        return currentChild;
    }

    public String registryReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Registered children in %s", this.name));

        Collections.sort(this.data , Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName));

        for (int i = 0; i < data.size(); i++) {
            stringBuilder.append(String.format("%n--%n"));
            stringBuilder.append(String.format("%s", data.get(i)));
        }

        return stringBuilder.toString().trim();
    }
}
