package at.fhtw.swkom.paperless.persistance.repositories.exceptions;

public class CouldNotUploadFileException extends Throwable {
    public CouldNotUploadFileException(String message) {
        super(message);
    }
}
