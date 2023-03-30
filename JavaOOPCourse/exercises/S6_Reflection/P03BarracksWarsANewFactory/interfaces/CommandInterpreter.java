package S6_Reflection.P03BarracksWarsANewFactory.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
