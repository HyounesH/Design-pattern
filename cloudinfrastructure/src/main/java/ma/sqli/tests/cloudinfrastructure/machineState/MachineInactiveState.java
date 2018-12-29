package ma.sqli.tests.cloudinfrastructure.machineState;

import ma.sqli.tests.cloudinfrastructure.entities.Machine;

public class MachineInactiveState extends MachineState {

	public MachineInactiveState(Machine machine) {
		super(machine);
		// TODO Auto-generated constructor stub
	    setState("inactive");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
