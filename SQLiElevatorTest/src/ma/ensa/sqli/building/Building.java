package ma.ensa.sqli.building;

import java.util.ArrayList;
import java.util.List;

public class Building {
	
	private int numberOfFloors;
	private List<Elevator> elevators;
	private Dispatcher dispatcher=Dispatcher.getInstance();
	/**
	 * 
	 * @param numberOfFloors : the number of floors of the building
	 * @param elevators : list of elevators of the building
	 * an elevator is describe by [elevator_id]:[elevator_current_floor]
	 */
	
	public Building(int numberOfFloors,String...elevators) {
		this.numberOfFloors=numberOfFloors;
		this.elevators=new ArrayList<>();
		for (String elevator : elevators) {
			this.elevators.add(new Elevator(numberOfFloors,elevator.split(":")[0],Integer.parseInt(elevator.split(":")[1])));
		}
		dispatcher.init(this.elevators);
	}
	
	public String requestElevator() {
		return dispatcher.requestElevator(this.numberOfFloors);
	}
	public String requestElevator(int floor) {
		return dispatcher.requestElevator(floor);
	}
	public void move(String id_elevator, String state) {
		for(Elevator elevator:elevators) {
			if(elevator.getElevator_id().equals(id_elevator)) {
				if(state=="UP") elevator.getElevatorState().up();
				if(state=="DOWN") elevator.getElevatorState().down();
				break;
			}
		}
	}
	public void stopAt(String id_elevator, int floor) {
		for(Elevator elevator:elevators) {
			if(elevator.getElevator_id().equals(id_elevator)) {
				elevator.setElevator_current_floor(floor);
				elevator.getElevatorState().stop();
				break;
			}
		}
	}
	

}
