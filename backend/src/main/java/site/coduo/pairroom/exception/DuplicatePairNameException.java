package site.coduo.pairroom.exception;

public class DuplicatePairNameException extends PairRoomException {

    public DuplicatePairNameException(final String message) {
        super(message);
    }

    public DuplicatePairNameException(final String message, final Throwable cause) {
        super(message, cause);
    }
}