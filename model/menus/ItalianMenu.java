
public class ItalianMenu extends Menu {

	public ItalianMenu(){
		initItalianMenu();
	}

	private void initItalianMenu() {
		addMenuItem(1, new Dish("Lasagna", 38, 40));
		addMenuItem(2, new Dish("Pasta con pesto", 30, 10));
		addMenuItem(3, new Dish("Spaghetti Carbonara", 12, 5));
		addMenuItem(4, new Dish("Gnocchi Sorrento", 20, 40));
		addMenuItem(5, new Dish("Pizza quattro formaggi", 20, 40));
		addMenuItem(101, new Dish("Water", 0, 0));
		addMenuItem(151, new Dish("Proasecco", 10, 0));
		addMenuItem(201, new Dish("Cigarette", 1, 0));
	}

}
