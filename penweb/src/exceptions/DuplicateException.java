package exceptions;
/**
 * 
 * @author Peng Ren
 * This exception is used to check if there will be a duplication
 * when the user tries to add a category or example
 *
 */
public class DuplicateException extends PENException{

	public DuplicateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
