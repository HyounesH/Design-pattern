package ma.sqli.tests.cloudinfrastructure.exceptions;

public class MachineStateException extends IllegalStateException {

	public MachineStateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MachineStateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MachineStateException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public MachineStateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Machine is already in the same state (started/topped) !";
	}

}
