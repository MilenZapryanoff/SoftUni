package S6_Reflection.P03BarracksWarsANewFactory.interfaces;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
