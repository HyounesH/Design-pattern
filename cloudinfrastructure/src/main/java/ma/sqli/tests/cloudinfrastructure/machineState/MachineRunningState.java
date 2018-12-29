package ma.sqli.tests.cloudinfrastructure.machineState;

import ma.sqli.tests.cloudinfrastructure.entities.Machine;
import ma.sqli.tests.cloudinfrastructure.exceptions.MachineStateException;

public class MachineRunningState extends MachineState {

	public MachineRunningState(Machine machine) {
		super(machine);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void stop() {
		machine.setMachineState(new MachineStoppedState(machine));
	}

	@Override
	public void run() {
	 throw new MachineStateException("machine is already running");
	}

}
