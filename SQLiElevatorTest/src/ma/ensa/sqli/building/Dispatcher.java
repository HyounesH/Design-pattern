package ma.ensa.sqli.building;

import java.util.List;

public class Dispatcher {
	private List<Elevator> elevators;
	public static Dispatcher _instance=null;
	private Dispatcher() {
	}
	public static Dispatcher getInstance() {
		if(_instance==null) {
			return new Dispatcher();
		}
		return _instance;
	}
	public void init(List<Elevator> elevators) {
		this.elevators=elevators;
	}
	public List<Elevator> getElevators() {
		return elevators;
	}
	public void setElevators(List<Elevator> elevators) {
		this.elevators = elevators;
	}
	public String requestElevator(int floor) {
		int minDistance=10;
		String idElevatorRequested=null;
		for(Elevator elevator:elevators) {
			if(elevator.distanceFromFloor(floor)!=-1 && elevator.distanceFromFloor(floor)<minDistance) {
				minDistance=elevator.distanceFromFloor(floor);
				idElevatorRequested=elevator.getElevator_id();
			}
		}
		return idElevatorRequested;
	}
	
	
	

}
