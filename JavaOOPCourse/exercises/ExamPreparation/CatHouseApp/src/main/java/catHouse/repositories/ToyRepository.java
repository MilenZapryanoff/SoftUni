package catHouse.repositories;

import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository {

    private Collection<Toy> toys;

    public ToyRepository() {
        toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        for (Toy currentToy : toys) {
            if (currentToy == toy){
                toys.remove(toy);
            return true;
            }
        }
        return false;
    }

    @Override
    public Toy findFirst(String type) {
        for (Toy toy : toys) {
            if (toy.getClass().getSimpleName().equals(type)){
                return toy;
            }
        }
        return null;
    }
}
