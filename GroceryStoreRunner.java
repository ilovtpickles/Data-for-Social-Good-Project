
public class GroceryStoreRunner {

  public static void main(String[] args) {

    UserStory groceryAnalyzer = new UserStory(
      "groceryInfo.txt",
      "groceryNumbers.txt"
    );

    System.out.println(groceryAnalyzer);
  }
}
