import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class ItalianRestaurant extends Restaurant  {

	public ItalianRestaurant() {
		// System.out.println("Italian restaurant created");

		employees = new ArrayList<>();
		tables = new HashMap<>();
		menu = new ItalianMenu();

		initItalianRestaurant();
	}

	private void initItalianRestaurant() {
		initTables();
		addEmployee(new Cashier());
		addEmployee(new Manager());
		addEmployee(new Manager());

		for (int i = 0; i < 4; i++) {
			addEmployee(new Waiter());
			addEmployee(new Cheff());
		}

	}

	private void initTables() {
		Random random = new Random();

		for (int id = 1; id <= 15; id++)
		{
			int nrOfSeats = random.nextInt(4) + 1; // [1; 4]
			tables.put(id, new SimpleTable(nrOfSeats));
		}

		for (int id = 101; id <= 103; id++)
		{
			int nrOfSeats = random.nextInt(4) + 1; // [1; 4]
			tables.put(id, new VipTable(nrOfSeats));
		}

		tables.put(201, new ChildrenTable(4));

		super.nrOfFreeTables = tables.size();
	}

	public void operate() {	}

	public boolean addEmployee(Employee employee) {
		employees.add(employee);
		return true;
	}

}
