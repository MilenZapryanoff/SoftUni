package S6_Reflection.P03BarracksWarsANewFactory.core.commands;

import S6_Reflection.P03BarracksWarsANewFactory.interfaces.Repository;
import S6_Reflection.P03BarracksWarsANewFactory.interfaces.UnitFactory;

public class FightCommand extends Command{
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
