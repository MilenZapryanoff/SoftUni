package S6_Reflection.P03BarracksWarsANewFactory.core.commands;

import S6_Reflection.P03BarracksWarsANewFactory.interfaces.Repository;
import S6_Reflection.P03BarracksWarsANewFactory.interfaces.Unit;
import S6_Reflection.P03BarracksWarsANewFactory.interfaces.UnitFactory;

public class AddCommand extends Command{
    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
