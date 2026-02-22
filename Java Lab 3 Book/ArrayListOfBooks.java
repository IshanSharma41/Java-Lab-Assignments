import java.util.ArrayList;

public class ArrayListOfBooks {
    public static void main(String[] args) {

        ArrayList<Book> alb = new ArrayList<>();

        try {
            alb.add(new Book());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            alb.add(new Book(
                    "Java Programming",
                    499.99,
                    "ISBN001",
                    "Educational",
                    "James Gosling"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            alb.add(new Book(
                    "Harry Potter and The Goblet of Fire",
                    550.00,
                    "ISBN002",
                    "Fiction",
                    "J.K. Rowling"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            alb.add(new Book(
                    "Death Note",
                    699.00,
                    "ISBN003",
                    "Fiction",
                    "Tsugumi Ohba"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            alb.add(new Book(
                    "The Art of War",
                    399.00,
                    "ISBN004",
                    "Non-fiction",
                    "Sun Tzu"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int len = 0;
        System.out.println("List of fiction books:");

        for (Book b : alb) {
            if (b.genre.equals("Fiction")) {
                System.out.println("------------------");
                System.out.println(b.title);
                System.out.println(b.price);
                System.out.println(b.author);
                System.out.println(b.ISBN);
                System.out.println(b.genre);
                System.out.println("------------------");
                len++;
            }
        }

        System.out.println("Fiction books: " + len);

        double temp = 0;

        for (Book b : alb) {
            temp += b.price;
        }

        if (alb.size() > 0)
            System.out.println("Average price: " + temp / alb.size());
    }
}