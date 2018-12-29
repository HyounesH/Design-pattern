package ma.sqli.tests.cloudinfrastructure.dispatcher;

import java.util.List;

import ma.sqli.tests.cloudinfrastructure.entities.Machine;
import ma.sqli.tests.cloudinfrastructure.entities.Store;
import ma.sqli.tests.cloudinfrastructure.exceptions.CreateStoreException;

public class Dispatcher {
	public static Dispatcher _instance = null;
	List<Machine> machines;
	List<Store> stores;

	/**
	 * pour eviter la creation par default d'un objet Dispatcher
	 */
	private Dispatcher() {
	}

	public static Dispatcher getInstance() {
		if (_instance == null)
			return new Dispatcher();
		return _instance;
	}

	public void init(List<Machine> machines, List<Store> stores) {
		this.stores = stores;
		this.machines = machines;
	}

	public void createMachine(String machineName, String operatingSystem, String diskSize, String memory) {
		machines.add(new Machine(machineName, operatingSystem, diskSize, memory));
	}

	public String listMachines() {
		String resultat = "";
		for (Machine machine : machines) {
			resultat += machine.getMachineName() + ":" + machine.getMachineState().getState() + "||";
		}
		return resultat.substring(0, resultat.length() - 2);
	}

	public void stopMachine(String machineName) {
		for (Machine machine : machines) {
			if (machine.getMachineName().equals(machineName)) {
				machine.getMachineState().stop();
				machine.getMachineState().setState("stopped");
				break;
			}
		}

	}

	public void startMachine(String machineName) {
		for (Machine machine : machines) {
			if (machine.getMachineName().equals(machineName)) {
				machine.getMachineState().run();
				machine.getMachineState().setState("running");
				break;
			}
		}
	}

	public void createStore(String storeName) {
		try {
			isStoreExit(storeName);
		} catch (CreateStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stores.add(new Store(storeName));

	}

	public void uploadDocument(String storeName, String... documents) {
		for (Store store : stores) {
			if (store.getStoreName().equals(storeName)) {
				addListOfStringToList(store.getDocuments(), documents);
			}
		}
	}

	public String listStores() {
		String resultat = "";
		for (Store store : stores) {
			resultat += store.getStoreName() + ":";
			if (store.getDocuments().isEmpty())
				resultat += "empty";
			else {
				for (String doc : store.getDocuments()) {
					resultat += doc + ", ";
				}
				resultat = resultat.substring(0, resultat.length() - 2);
			}
			resultat += "||";

		}
		resultat = resultat.substring(0, resultat.length() - 2);
		return resultat;
	}

	public void addListOfStringToList(List<String> list, String... doc) {
		for (String d : doc) {
			list.add(d);
		}
	}

	public void deleteStore(String storeName) {
		for (Store store : stores) {
			if (store.getStoreName().equals(storeName)) {
				stores.remove(store);
				break;
			}
		}
	}

	public void emptyStore(String storeName) {
		for (Store store : stores) {
			if (store.getStoreName().equals(storeName)) {
				store.getDocuments().removeAll(store.getDocuments());
			}
		}

	}

	public int usedMemory(String machineName) {
		int memory = 0;
		for (Machine machine : machines) {
			if (machine.getMachineName().equals(machineName) && machine.getMachineState().getState() == "running") {
				memory = Integer.parseInt(machine.getMemory().substring(0, machine.getMemory().length() - 2));
				break;
			}
		}
		return memory;

	}

	public double usedDisk(String Name) {
		double diskSize = 0;
		for (Machine machine : machines) {
			if (machine.getMachineName().equals(Name)) {
				diskSize = Integer.parseInt(machine.getDiskSize().substring(0, machine.getDiskSize().length() - 2));
				break;
			}
		}
		if (diskSize == 0) {
			for (Store store : stores) {
				if (store.getStoreName().equals(Name)) {
					diskSize = 0.100 * store.getDocuments().size();
					break;
				}
			}
		}
		return diskSize;
	}

	public double globalUsedDisk() {
		double globalUsedDisk = 0;
		for (Machine machine : machines) {
			globalUsedDisk += Integer.parseInt(machine.getDiskSize().substring(0, machine.getDiskSize().length() - 2));
		}
		for (Store store : stores) {
			globalUsedDisk += 0.100 * store.getDocuments().size();

		}

		return globalUsedDisk;
	}

	public double globalUsedMemory() {
		double globalUserMemory = 0;
		for (Machine machine : machines) {
			if (machine.getMachineState().getState() == "running") {
				globalUserMemory += Double
						.parseDouble(machine.getMemory().substring(0, machine.getMemory().length() - 2));
			}
		}
		return globalUserMemory;
	}

	/**
	 * check if store is already exist
	 * 
	 * @param storeName:store name
	 */
	public void isStoreExit(String storeName) throws CreateStoreException{
		boolean isExist = false;
		for (Store store : stores) {
			if (store.getStoreName().equals(storeName)) {
				isExist = true;
				break;
			}
		}
		if(isExist) throw new CreateStoreException();

	}
}