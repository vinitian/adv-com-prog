public class InvalidTransactionException extends Exception {
    public InvalidTransactionException() {
        super("Not enough balance in the source wallet.");
    }
    public InvalidTransactionException(String message) {
        super(message);
    }
}