package excepstion;

import javax.servlet.ServletException;

public class BookException extends ServletException{

	private static final long serialVersionUID = -7628932175090321103L;

	public BookException(String messege) {
		super(messege);
	}
	
}
