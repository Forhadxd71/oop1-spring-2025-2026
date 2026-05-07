public class StoryBook extends Book {
    private String category;

    public StoryBook() {}

    public StoryBook(String isbn, String title, String author, double price, int qty, String category) {
        super(isbn, title, author, price, qty);
        this.category = category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void showDetails() {
        System.out.println("StoryBook:");
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Title: " + getBookTitle());
        System.out.println("Author: " + getAuthorName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getAvailableQuantity());
        System.out.println("Category: " + category);
        System.out.println("----------------------");
    }
}
