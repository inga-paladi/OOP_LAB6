import java.util.HashMap;
import java.util.Map;

public class Menu {

	protected HashMap<Integer, Dish> dishes;

	public Menu(){
		this.dishes = new HashMap<>();
	}

	void displayDishes() {
		for (Map.Entry<Integer, Dish> menuEntry: dishes.entrySet())
		{
			Dish dish = menuEntry.getValue();
			System.out.println(String.valueOf(menuEntry.getKey())
				+ ": "
				+ dish.Name
				+ ". $"
				+ dish.Price
				+ ". AvgPrep: "
				+ dish.AvgPrepTime
				+ " min");
		}
	}

	void addMenuItem(Integer ID, Dish dish)
	{
		dishes.put(ID, dish);
	}

	HashMap<Integer, Dish> getDishes() {
		return dishes;
	}
}
