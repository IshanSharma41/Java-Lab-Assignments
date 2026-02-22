public class InvalidBookGenreException extends ExceptionClass {

    public InvalidBookGenreException(String genre) {
        super("Invalid Book Genre: " + genre);
    }
}