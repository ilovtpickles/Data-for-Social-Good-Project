
public class UserStory {

  private GroceryStore[] stores;
  private String[] info;
  private double[] numbers;

  /*
   * Reads the two files.
   * Makes 6 grocery store objects.
   */
  public UserStory() {
    this("groceryInfo.txt", "groceryNumbers.txt");
  }

  public UserStory(String infoFile, String numbersFile) {

    info = FileReader.toStringArray(infoFile);
    numbers = FileReader.toDoubleArray(numbersFile);

    stores = new GroceryStore[6];

    for (int i = 0; i < 6; i++) {
      stores[i] = new GroceryStore(
        info[i * 2],
        info[i * 2 + 1],
        numbers[i * 2],
        numbers[i * 2 + 1]
      );
    }
  }

  /*
   * Finds the average price.
   * Returns the average.
   */
  public double getAveragePrice() {
    double total = 0;

    for (int i = 0; i < stores.length; i++) {
      total += stores[i].getPrice();
    }

    return total / stores.length;
  }

  /*
   * Finds the highest quality.
   * Returns the best one.
   */
  public GroceryStore findBestQuality() {
    int best = 0;

    for (int i = 1; i < stores.length; i++) {
      if (stores[i].getQuality() > stores[best].getQuality()) {
        best = i;
      }
    }

    return stores[best];
  }

  /*
   * Finds the best quality for the price.
   * Returns the best value.
   */
  public GroceryStore getBestValue() {
    int best = 0;

    for (int i = 1; i < stores.length; i++) {
      double current = stores[i].getQuality() / stores[i].getPrice();
      double highest = stores[best].getQuality() / stores[best].getPrice();

      if (current > highest) {
        best = i;
      }
    }

    return stores[best];
  }

  /*
   * Shows the grocery information.
   * Returns the results.
   */
  public String toString() {
    return "Grocery Store Ingredient Analyzer"
      + "\nNumber of Listings: " + stores.length
      + "\nAverage Price: $" + getAveragePrice()
      + "\nBest Quality: " + findBestQuality()
      + "\nBest Value: " + getBestValue();
  }
}
