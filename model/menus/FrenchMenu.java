
public class FrenchMenu extends Menu {

	public FrenchMenu(){
		initFrenchMenu();
	}

	private void initFrenchMenu() {
		addMenuItem(1, new Dish("Croissant", 10, 40));
		addMenuItem(2, new Dish("Baguette", 2, 0));
		addMenuItem(3, new Dish("Bruschette", 4, 5));
		addMenuItem(4, new Dish("Fromage mozzarella", 14, 3));
		addMenuItem(101, new Dish("Water", 0, 0));
		addMenuItem(151, new Dish("Rose sparkling wine", 10, 0));
		addMenuItem(201, new Dish("Cigarette", 1, 0));
	}

}