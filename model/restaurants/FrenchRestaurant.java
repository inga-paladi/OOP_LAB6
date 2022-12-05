import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

class FrenchRestaurant extends Restaurant  {

	public FrenchRestaurant() {
		// System.out.println("French restaurant created");
		super.employees = new ArrayList<>();
		super.tables = new HashMap<>();
		super.menu = new FrenchMenu();

		initFrenchRestaurant();
	}
	
	private void initFrenchRestaurant() {
		initTables();

		addEmployee(new Cashier());
		addEmployee(new Manager());

		for (int i = 0; i < 2; i++) {
			addEmployee(new Waiter());
			addEmployee(new Cheff());
		}
	
	}

	private void initTables() {
		Random random = new Random();

		for (int id = 1; id <= 20; id++)
		{
			int nrOfSeats = random.nextInt(4) + 1; // [1; 4]
			super.tables.put(id, new SimpleTable(nrOfSeats));
		}
		
		for (int id = 100; id <= 110; id++)
		{
			int nrOfSeats = random.nextInt(4) + 1; // [1; 4]
			super.tables.put(id, new VipTable(nrOfSeats));
		}
		
		super.nrOfFreeTables = super.tables.size();
	}
	
	public void operate() { }
	
	public boolean addEmployee(Employee employee) {
		super.employees.add(employee);
		return true;
	}
	
}
