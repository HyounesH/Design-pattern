package ma.sqli.tests.cloudinfrastructure.exceptions;

public class CreateStoreException  extends Exception{

	
	
	public CreateStoreException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateStoreException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CreateStoreException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CreateStoreException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CreateStoreException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Store is already created !";
	}

}
