package ma.sqli.tests.cloudinfrastructure;

import java.util.ArrayList;
import java.util.List;

import ma.sqli.tests.cloudinfrastructure.dispatcher.Dispatcher;
import ma.sqli.tests.cloudinfrastructure.entities.Machine;
import ma.sqli.tests.cloudinfrastructure.entities.Store;

public class CloudInfrastructure {
	/**
	 * i created dispatcher to manage stores and machines
	 */
	private Dispatcher dispatcher=Dispatcher.getInstance();
	/**
	 * list of machines of the cloud
	 */
	List<Machine> machines;
	/**
	 * list of stores of the cloud
	 */
	List<Store> stores;
	public CloudInfrastructure() {
		this.stores=new ArrayList<>();
		this.machines=new ArrayList<>();
		dispatcher.init(machines, stores);
	}
	/**
	 * 
	 * @param machineName : machine name
	 * @param operatingSystem : the operating system exemple 'Linux','Windows'
	 * @param diskSize : disk size of machine
	 * @param memory : memory size of machine
	 */
	public void createMachine(String machineName, String operatingSystem, String diskSize, String memory) {
		dispatcher.createMachine(machineName,operatingSystem,diskSize,memory);
	}
	public String listMachines() {
		return dispatcher.listMachines();
	}
	public void startMachine(String machineName ) {
		dispatcher.startMachine(machineName);
	}
	public void stopMachine(String machineName) {
		dispatcher.stopMachine(machineName);
		
	}
	
	public void createStore(String storeName) {
		dispatcher.createStore(storeName);
	}
	public String listStores() {
		// TODO Auto-generated method stub
		return dispatcher.listStores();
	}
	public void uploadDocument(String storeName,String...documents) {
		dispatcher.uploadDocument(storeName,documents);
	}

	public void deleteStore(String storeName) {
		dispatcher.deleteStore(storeName);
		
	}

	public void emptyStore(String storeName) {
		dispatcher.emptyStore(storeName);
		
	}

	public double usedMemory(String machineName) {
		return dispatcher.usedMemory(machineName);
	}

	public double usedDisk(String machineName) {
		return dispatcher.usedDisk(machineName);
	}

	public double globalUsedDisk() {
		return dispatcher.globalUsedDisk();
		
	}

	public double globalUsedMemory() {
		// TODO Auto-generated method stub
		return dispatcher.globalUsedMemory();
	}

}
