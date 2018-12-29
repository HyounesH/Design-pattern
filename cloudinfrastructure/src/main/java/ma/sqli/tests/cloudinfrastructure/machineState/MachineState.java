package ma.sqli.tests.cloudinfrastructure.machineState;

import ma.sqli.tests.cloudinfrastructure.entities.Machine;

public abstract class MachineState {
	protected Machine machine;
	protected String state;

	public MachineState(Machine machine) {
		super();
		this.machine = machine;
	}
	
	public abstract void stop();
	public abstract void run();

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
