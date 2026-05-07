public class Start {
    public static void main(String[] args) {

        BookShop shop = new BookShop("My Book Shop");

        StoryBook s1 = new StoryBook("S1", "Golpo 1", "Author A", 200, 10, "Fiction");
        StoryBook s2 = new StoryBook("S2", "Golpo 2", "Author B", 250, 5, "Drama");

        TextBook t1 = new TextBook("T1", "Math", "Author X", 400, 10, 10);
        TextBook t2 = new TextBook("T2", "Physics", "Author Y", 450, 8, 11);

        shop.insertBook(s1);
        shop.insertBook(s2);

        shop.insertBook(t1);
        shop.insertBook(t2);

        shop.showAllBooks();

        Book b = shop.searchBook("T3");
        if (b != null) {
            System.out.println("Found Book:");
            b.showDetails();
        }

        t1.sellQuantity(2);
        t1.addQuantity(5);

        System.out.println("After update:");
        t1.showDetails();
    }
}
