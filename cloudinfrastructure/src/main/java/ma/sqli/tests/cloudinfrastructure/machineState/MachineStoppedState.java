package ma.sqli.tests.cloudinfrastructure.machineState;

import ma.sqli.tests.cloudinfrastructure.entities.Machine;
import ma.sqli.tests.cloudinfrastructure.exceptions.MachineStateException;

public class MachineStoppedState  extends MachineState{

	public MachineStoppedState(Machine machine) {
		super(machine);
		// TODO Auto-generated constructor stub
		setState("stopped");
	}

	@Override
	public void stop() {
		throw new MachineStateException("machine is already stopped");
		
	}

	@Override
	public void run() {
		machine.setMachineState(new MachineRunningState(machine));
		
		
	}

}
