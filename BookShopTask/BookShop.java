public class BookShop implements BookShopOperations {
    private String name;
    private Book[] listOfBooks = new Book[100];

    public BookShop() {}

    public BookShop(String name) {
        this.name = name;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public boolean insertBook(Book b) {
        for (int i = 0; i < listOfBooks.length; i++) {
            if (listOfBooks[i] == null) {
                listOfBooks[i] = b;
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean removeBook(Book b) {
        for (int i = 0; i < listOfBooks.length; i++) {
            if (listOfBooks[i] == b) {
                listOfBooks[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void showAllBooks() {
        for (Book listOfBook : listOfBooks) {
            if (listOfBook != null) {
                listOfBook.showDetails();
            }
        }
    }

    @Override
    public Book searchBook(String isbn) {
        for (Book listOfBook : listOfBooks) {
            if (listOfBook != null && listOfBook.getIsbn().equals(isbn)) {
                return listOfBook;
            }
        }
        return null;
    }

    public Book[] getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(Book[] listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
