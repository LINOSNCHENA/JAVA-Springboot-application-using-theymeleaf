<<<<<<< HEAD
=======

>>>>>>> 40e95137a81f480a9926446d9c04b44eea8201b0
package com.monze.praha.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
<<<<<<< HEAD
public class RecordNotFoundException extends Exception 
{
	private static final long serialVersionUID = 1L;
	public RecordNotFoundException(String message)				{	super(message);		}
	public RecordNotFoundException(String message, Throwable t) {	super(message, t);	}
=======
public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(String message) {
		super(message);
	}
	
	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}
>>>>>>> 40e95137a81f480a9926446d9c04b44eea8201b0
}
