package robotService.repositories;

import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepository implements Repository {
    private Collection<Supplement> supplements;

    public SupplementRepository() {
        supplements = new ArrayList<>();
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public boolean removeSupplement(Supplement supplement) {

        for (Supplement currentSupplement : supplements) {
            if (currentSupplement == supplement) {
                this.supplements.remove(supplement);
                return true;
            }
        }
        return false;
    }

    @Override
    public Supplement findFirst(String type) {
        for (Supplement supplement : supplements) {
            if (supplement.getClass().getSimpleName().equals(type)) {
                return supplement;
            }
        }
        return null;
    }
}
