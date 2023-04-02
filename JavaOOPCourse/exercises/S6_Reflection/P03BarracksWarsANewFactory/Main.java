package S6_Reflection.P03BarracksWarsANewFactory;

import S6_Reflection.P03BarracksWarsANewFactory.core.commands.CommandInterpreterImpl;
import S6_Reflection.P03BarracksWarsANewFactory.interfaces.CommandInterpreter;
import S6_Reflection.P03BarracksWarsANewFactory.interfaces.Repository;
import S6_Reflection.P03BarracksWarsANewFactory.interfaces.Runnable;
import S6_Reflection.P03BarracksWarsANewFactory.interfaces.UnitFactory;
import S6_Reflection.P03BarracksWarsANewFactory.core.Engine;
import S6_Reflection.P03BarracksWarsANewFactory.core.factories.UnitFactoryImpl;
import S6_Reflection.P03BarracksWarsANewFactory.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
    //Repository -> keeps track of units and their count
    //UnitFactory -> create units
    //Engine -> parse and execute command
}
