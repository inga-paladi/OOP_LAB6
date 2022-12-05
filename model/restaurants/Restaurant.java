import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Restaurant {
	protected String adress;
	protected ArrayList<Employee> employees;
	protected ArrayList<Waiter> waiters;
	protected Menu menu;
	protected String name;
	protected String owner;
	protected int nrOfFreeTables;
	protected HashMap<Integer, Table> tables;

	public HashMap<Integer, Table> getFreeTable() {
		HashMap<Integer, Table> freeTables = new HashMap<>();
		for (Map.Entry<Integer, Table> table: tables.entrySet())
		{
			if (table.getValue().isAvailable())
				freeTables.put(table.getKey(), table.getValue());
		}
		return freeTables;
	}

	public Menu getMenu() {
		return menu;
	}

	public int getNrOfTables() {
		return tables.size();
	}

	public int getNrOfFreeTables() {
		return nrOfFreeTables;
	}

	public boolean occupyTable(int tableId) {
		try {
			boolean tableOcupied;
			tableOcupied = tables.get(tableId).occupy();
			if (tableOcupied)
			{
				nrOfFreeTables--;
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public abstract void operate();
	public abstract boolean addEmployee(Employee employee);
}
