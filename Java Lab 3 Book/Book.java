public class Book {
    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    public Book() {
        this.title = "Not Assigned";
        this.author = "Unknown";
        this.genre = "General";
        this.ISBN = "N/A";
        this.price = 0.0;
    }

    public Book(String title, double price, String genre)
            throws InvalidPriceException, InvalidBookGenreException {

        this.title = title;

        if (price < 0)
            throw new InvalidPriceException("Price cannot be negative");

        this.price = price;

        if (!genre.equals("Fiction") &&
            !genre.equals("Non-fiction") &&
            !genre.equals("Educational") &&
            !genre.equals("Auto-biography") &&
            !genre.equals("Fantasy"))
            throw new InvalidBookGenreException("Invalid genre");

        this.genre = genre;
    }

    public Book(String title, double price, String ISBN,
                String genre, String author)
            throws InvalidPriceException, InvalidBookGenreException {

        this.title = title;

        if (price < 0)
            throw new InvalidPriceException("Price cannot be negative");

        this.price = price;
        this.ISBN = ISBN;

        // ✅ SAME allowed genres everywhere
        if (!genre.equals("Fiction") &&
            !genre.equals("Non-fiction") &&
            !genre.equals("Educational") &&
            !genre.equals("Auto-biography"))
            throw new InvalidBookGenreException("Invalid genre");

        this.genre = genre;
        this.author = author;
    }

    public Book(Book b) {
        this.title = b.title;
        this.price = b.price;
        this.ISBN = b.ISBN;
        this.genre = b.genre;
        this.author = b.author;
    }
}