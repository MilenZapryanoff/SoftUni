package S2_Encapsulation.P02AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length() >= 1) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {
        if (age >= 0 && age <= 15) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

    }
    public double productPerDay () {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggsPerDay;
        if (this.age >= 0 && this.age <= 5) {
            eggsPerDay = 2;
        } else if (this.age >= 6 && this.age <= 11) {
            eggsPerDay = 1;
        } else {
            eggsPerDay = 0.75;
        }
        return eggsPerDay;
    }

    @Override
    public String toString() {
       return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, this.productPerDay() );
    }
}
