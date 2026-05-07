public class TextBook extends Book {
    private int standard;

    public TextBook() {}

    public TextBook(String isbn, String title, String author, double price, int qty, int standard) {
        super(isbn, title, author, price, qty);
        this.standard = standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getStandard() {
        return standard;
    }

    public void showDetails() {
        System.out.println("TextBook:");
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Title: " + getBookTitle());
        System.out.println("Author: " + getAuthorName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getAvailableQuantity());
        System.out.println("Standard: " + standard);
        System.out.println("----------------------");
    }
}
