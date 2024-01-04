package at.fhtw.swkom.paperless.persistance.repositories.exceptions;

public class CouldNotDeleteFileException extends Throwable {
    public CouldNotDeleteFileException(String message) {
        super(message);
    }
}
