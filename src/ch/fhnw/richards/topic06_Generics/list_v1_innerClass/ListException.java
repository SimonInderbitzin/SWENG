package ch.fhnw.richards.topic06_Generics.list_v1_innerClass;

/**
 * These error codes could be enhanced with real error messages.
 */
public class ListException extends Exception {
	enum ListErrorCode { PositionTooSmall, PositionTooLarge; }

	public ListException(ListErrorCode error) {
		super(error.toString());
	}
}