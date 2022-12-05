import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Runnable;

class ClientSimulation implements Runnable {

	private OOP_View m_view;
    private int m_clientID;
    private Random m_random;
	private Restaurant m_restaurant;
	private boolean m_clientHasChildren;
	private ArrayList<Integer> m_selectedTablesId;
	protected HashMap<Integer, Dish> m_orderedDishes;

    public void run() {
        simulate();
    }

	public ClientSimulation(OOP_View view) {
		this.m_view = view;
		this.m_random = new Random();
        this.m_clientID = m_random.nextInt(10000);
		this.m_selectedTablesId = new ArrayList<>();
		this.m_orderedDishes = new HashMap<>();

        m_view.Format("Client with id %d created\n", m_clientID);
	}

	public void simulate() {
        m_view.Format("Simulation for client %d started\n", m_clientID);

		if (indicateChildPresence()
			&& selectRestaurant()
			&& choseTable()
			&& callWaiter()
			&& getMenu()
			&& makeOrders())
        {
            try {
                TimeUnit.SECONDS.sleep(m_random.nextInt(10));
                checkOut();
            } catch (Exception exception) { }
        }
		else { return; }
	}

	protected boolean indicateChildPresence() {
		m_clientHasChildren = m_random.nextBoolean();
		if (m_clientHasChildren)
			m_view.Format("Client %d has children\n", m_clientID);
		else
			m_view.Format("Client %d doesn't have children\n", m_clientID);
		return true;
	}

	protected boolean selectRestaurant() {
		final int nrOfRestaurants = 2;
		final int chosenRestaurant = m_random.nextInt(nrOfRestaurants);

		if (chosenRestaurant == 0) { // italian restaurant
			m_restaurant = new ItalianRestaurant();
			m_view.Format("Client %d has chosen italian restaurant\n", m_clientID);
		} else { // french restaurant
			if (m_clientHasChildren)
			{
				m_view.Format("French restaurant does not have child "
                    + "tables for client %d\n", m_clientID);
				return false;
			}
			m_restaurant = new FrenchRestaurant();
            m_view.Format("Client %d has chosen french restaurant\n", m_clientID);
		}

		return true;
	}

	protected boolean choseTable() {
		if (m_restaurant.getNrOfFreeTables() == 0) {
			m_view.Format("No tables available for client %d\n", m_clientID);
			return false;
		}

		if (m_clientHasChildren)
		{
			final int childTableId = 201;
			if (m_restaurant.occupyTable(childTableId)) {
				m_view.Format("Child table occupied by client %d\n", m_clientID);
				m_selectedTablesId.add(childTableId);
			} else {
				m_view.Format("No free child tables for client %d\n", m_clientID);
				return false;
			}
		}

		for (Map.Entry<Integer, Table> table
			: m_restaurant.getFreeTable().entrySet())
		{
			if (m_restaurant.occupyTable(table.getKey()))
			{
				m_selectedTablesId.add(table.getKey());
				m_view.Format("Table %d occupied by client %d\n"
                    , table.getKey(), m_clientID);
				return true;
			}
		}
		m_view.Format("No free tables found for client %d\n", m_clientID);
		return false;
	}

	protected boolean callWaiter() {
		m_view.Format("Waiter came at the client %d\n", m_clientID);
		return true;
	}

	protected boolean getMenu() {
		// System.out.println("Menu");
		// m_restaurant.getMenu().displayDishes();
		// System.out.println("");
		return true;
	}


	protected boolean makeOrders() {
		HashMap<Integer, Dish> dishes = m_restaurant.getMenu().getDishes();

		if (!m_clientHasChildren) {
			if (m_restaurant instanceof FrenchRestaurant) {
				final int sparklingWine = 151;
				m_orderedDishes.put(sparklingWine, dishes.get(sparklingWine));
                m_view.Format("Sparkling wine was ordered by client %d\n", m_clientID);
			}
		} else {
			final int waterId = 101;
			m_orderedDishes.put(waterId, dishes.get(waterId));
            m_view.Format("Water was ordered by client %d\n", m_clientID);
		}

		final int maxNrOfOrders = 4;
		final int nrOfOrders = m_random.nextInt(maxNrOfOrders);
		for (int i = 0; i <= nrOfOrders; i++) {
			final int productId = m_random.nextInt(6);
			if (dishes.containsKey(productId))
			{
				final Dish dish = dishes.get(productId);
				m_orderedDishes.put(productId, dish);
				m_view.Format(dish.Name + " ordered successfully by client %d\n", m_clientID);
			}
		}

		return true;
	}

	protected boolean checkOut() {
		float sumToPay = 0;

		for (Map.Entry<Integer, Dish> dish: m_orderedDishes.entrySet()) {
			sumToPay += dish.getValue().Price;
		}

		m_view.Format("Client %d has to pay: $%f\n", m_clientID, sumToPay);
		return true;
	}
}