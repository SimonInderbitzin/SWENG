package ch.fhnw.richards.lecture06_Generics.solutions.ListEasy;

/**
 * These error codes could be enhanced with real error messages.
 */
public class ListException extends Exception {
	enum ListErrorCode { PositionTooSmall, PositionTooLarge; }

	public ListException(ListErrorCode error) {
		super(error.toString());
	}
}