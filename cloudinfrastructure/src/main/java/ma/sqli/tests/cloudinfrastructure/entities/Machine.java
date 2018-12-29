package ma.sqli.tests.cloudinfrastructure.entities;

import ma.sqli.tests.cloudinfrastructure.machineState.MachineInactiveState;
import ma.sqli.tests.cloudinfrastructure.machineState.MachineState;

public class Machine {
	private String machineName;
	private String operatingSystem;
	private String diskSize;
	private String memory;
	/**
	 * class that define the state of machine 
	 *  VM is always Inactive at its creation. We can then start or stop it.
	 */
	private MachineState machineState;
	public Machine(String machineName, String operatingSystem, String diskSize, String memory) {
		super();
		this.machineName = machineName;
		this.operatingSystem = operatingSystem;
		this.diskSize = diskSize;
		this.memory = memory;
		this.machineState=new MachineInactiveState(this);
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public MachineState getMachineState() {
		return machineState;
	}
	public void setMachineState(MachineState machineState) {
		this.machineState = machineState;
	}
	
	
	

}
